package com.batch14.productmanagementservice.service

import com.batch14.productmanagementservice.domain.dto.response.ResGetBrandDto

interface MasterBrandService {
    fun getAllBrand(): List<ResGetBrandDto>
    fun getBrandById(id: Int): ResGetBrandDto
}