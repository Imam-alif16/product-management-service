package com.batch14.productmanagementservice.controller

import com.batch14.productmanagementservice.domain.dto.response.BaseResponse
import com.batch14.productmanagementservice.domain.dto.response.ResGetBrandDto
import com.batch14.productmanagementservice.domain.dto.response.ResGetCarDto
import com.batch14.productmanagementservice.service.MasterCarService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/cars")
class CarController (
    private val masterCarService: MasterCarService
) {
    @GetMapping("/all")
    fun getAllBrand(): ResponseEntity<BaseResponse<List<ResGetCarDto>>>{
        return ResponseEntity.ok(
            BaseResponse(
                data = masterCarService.getAllCar()

            )
        )
    }
    @GetMapping("/{id}")
    fun getBrandById(@PathVariable id: Int): ResponseEntity<ResGetCarDto>{
        return ResponseEntity.ok(
            masterCarService.getCarById(id)
        )
    }
}