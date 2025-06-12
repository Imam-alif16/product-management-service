package com.batch14.productmanagementservice.service

import com.batch14.productmanagementservice.domain.dto.response.ResGetCarDto

interface MasterCarService {
    fun getAllCar(): List<ResGetCarDto>
    fun getCarById(id: Int): ResGetCarDto
}