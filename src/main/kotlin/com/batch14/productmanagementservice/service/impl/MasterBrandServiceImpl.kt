package com.batch14.productmanagementservice.service.impl

import com.batch14.productmanagementservice.domain.dto.response.ResGetBrandDto
import com.batch14.productmanagementservice.exception.CustomException
import com.batch14.productmanagementservice.repository.MasterBrandRepository
import com.batch14.productmanagementservice.service.MasterBrandService
import org.springframework.stereotype.Service

@Service
class MasterBrandServiceImpl(
    private val masterBrandRepository: MasterBrandRepository
): MasterBrandService {
    override fun getAllBrand(): List<ResGetBrandDto> {
        val rawData = masterBrandRepository.findAll()
        val result = mutableListOf<ResGetBrandDto>()
        rawData.forEach { data ->
            result.add(
                ResGetBrandDto(
                    id = data.id,
                    name = data.name
                )
            )
        }
        return result
    }

    override fun getBrandById(id: Int): ResGetBrandDto {
        val rawData = masterBrandRepository.findById(id)
            .orElseThrow {
                CustomException("Brand dengan id $id tidak ditemukan", 400)
            }

        return ResGetBrandDto(
            id = rawData.id,
            name = rawData.name
        )
    }
}