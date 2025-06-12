package com.batch14.productmanagementservice.controller

import com.batch14.productmanagementservice.domain.dto.response.BaseResponse
import com.batch14.productmanagementservice.domain.dto.response.ResGetBrandDto
import com.batch14.productmanagementservice.service.MasterBrandService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/brands")
class BrandController (
    private val masterBrandService: MasterBrandService
) {
    @GetMapping("/all")
    fun getAllBrand(): ResponseEntity<BaseResponse<List<ResGetBrandDto>>>{
        return ResponseEntity.ok(
            BaseResponse(
                data = masterBrandService.getAllBrand()

            )
        )
    }
    @GetMapping("/{id}")
    fun getBrandById(@PathVariable id: Int): ResponseEntity<ResGetBrandDto>{
        return ResponseEntity.ok(
            masterBrandService.getBrandById(id)
        )
    }
}