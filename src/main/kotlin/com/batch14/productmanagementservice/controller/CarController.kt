package com.batch14.productmanagementservice.controller

import com.batch14.productmanagementservice.domain.dto.request.ReqCreateDto
import com.batch14.productmanagementservice.domain.dto.response.BaseResponse
import com.batch14.productmanagementservice.domain.dto.response.ResGetBrandDto
import com.batch14.productmanagementservice.domain.dto.response.ResGetCarDto
import com.batch14.productmanagementservice.service.MasterCarService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/cars")
class CarController (
    private val masterCarService: MasterCarService
) {
    @GetMapping("/all")
    fun getAllCar(): ResponseEntity<BaseResponse<List<ResGetCarDto>>>{
        return ResponseEntity.ok(
            BaseResponse(
                data = masterCarService.getAllCar()

            )
        )
    }
    @GetMapping("/{id}")
    fun getCarById(@PathVariable id: Int): ResponseEntity<BaseResponse<ResGetCarDto>> {
        return ResponseEntity.ok(
            BaseResponse(
                data = masterCarService.getCarById(id)
            )

        )
    }

    @PostMapping("/create")
    fun createCar(
        @RequestBody req: ReqCreateDto
    ): ResponseEntity<BaseResponse<ResGetCarDto>> {
        return ResponseEntity(
            BaseResponse(
                data = masterCarService.createCar(req),
                message = "Berhasil membuat data mobil"
            ),
            HttpStatus.CREATED
        )
    }
}