package com.batch14.productmanagementservice.service.impl

import com.batch14.productmanagementservice.domain.constant.Constant
import com.batch14.productmanagementservice.domain.dto.request.ReqCreateDto
import com.batch14.productmanagementservice.domain.dto.response.ResGetCarDto
import com.batch14.productmanagementservice.domain.entity.MasterCarEntity
import com.batch14.productmanagementservice.exception.CustomException
import com.batch14.productmanagementservice.repository.MasterBrandRepository
import com.batch14.productmanagementservice.repository.MasterCarRepository
import com.batch14.productmanagementservice.rest.UserManagementClient
import com.batch14.productmanagementservice.service.MasterCarService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class MasterCarServiceImpl(
    private val masterCarRepository: MasterCarRepository,
    private val masterBrandRepository: MasterBrandRepository,
    private val userManagementClient: UserManagementClient,
    private val httpServletRequest: HttpServletRequest
): MasterCarService {
    override fun getAllCar(): List<ResGetCarDto> {
        val rawData = masterCarRepository.findAll()
        println(rawData)
        val result = mutableListOf<ResGetCarDto>()
        rawData.forEach { data ->
            result.add(
                ResGetCarDto(
                    id = data.id,
                    name = data.name,
                    color = data.color,
                    brandId = data.brand?.id
                )
            )
        }
        return result
    }

    override fun getCarById(id: Int): ResGetCarDto {
        val rawData = masterCarRepository.findById(id)
            .orElseThrow {
                CustomException("Car dengan id $id tidak ditemukan", 400)
            }
        println(rawData)
        var createdBy = rawData.createdBy
        println(createdBy)
        if(createdBy != null) {
            val user = userManagementClient.getUserById(
                createdBy.toInt()
            ).body!!.data!!
            createdBy = user.username
        }

        return ResGetCarDto(
            id = rawData.id,
            name = rawData.name,
            color = rawData.color,
            brandId = rawData.brand?.id,
            createdBy = createdBy
        )
    }

    override fun createCar(req: ReqCreateDto): ResGetCarDto {
        var roleId = httpServletRequest.getHeader(Constant.HEADER_USER_ROLE)
        if (roleId != "admin") {
            throw CustomException(
                "Tidak bisa tambah data kecuali admin",
                HttpStatus.BAD_REQUEST.value())
        }

        val existingCar = masterCarRepository.findFirstByName(req.name)
        if(existingCar.isPresent) {
            throw CustomException("nama sudah terdaftar", 400)
        }

        val brand = req.brandId?.let { id ->
            masterBrandRepository.findById(id)
                .orElseThrow { CustomException("Brand with id $id not found", 400) }
        }

        val carRaw = MasterCarEntity(
            name = req.name,
            color = req.color,
            brand = brand
        )

        val car = masterCarRepository.save(carRaw)
        return ResGetCarDto(
            id = car.id,
            name = car.name,
            color = car.color,
            brandId = carRaw.brand?.id
        )
    }
}