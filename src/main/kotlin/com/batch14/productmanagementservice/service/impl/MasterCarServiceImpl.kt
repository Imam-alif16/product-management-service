package com.batch14.productmanagementservice.service.impl

import com.batch14.productmanagementservice.domain.dto.response.ResGetCarDto
import com.batch14.productmanagementservice.domain.entity.MasterCarEntity
import com.batch14.productmanagementservice.exception.CustomException
import com.batch14.productmanagementservice.repository.MasterCarRepository
import com.batch14.productmanagementservice.rest.UserManagementClient
import com.batch14.productmanagementservice.service.MasterCarService
import org.springframework.stereotype.Service

@Service
class MasterCarServiceImpl(
    private val masterCarRepository: MasterCarRepository,
    private val userManagementClient: UserManagementClient
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
            val user = userManagementClient.getActiveUserById(
                createdBy.toInt()
            ).body!!.data!!
            createdBy = user.username
        }

        return ResGetCarDto(
            id = rawData.id,
            name = rawData.name,
            brandId = rawData.brand?.id,
            createdBy = createdBy
        )
    }
}