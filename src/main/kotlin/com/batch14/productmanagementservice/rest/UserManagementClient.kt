package com.batch14.productmanagementservice.rest

import com.batch14.productmanagementservice.domain.dto.response.BaseResponse
import com.batch14.productmanagementservice.domain.dto.response.ResGetUserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "user-service",
    path = "/user-service"
)
interface UserManagementClient {
    @GetMapping("v1/users/active/{id}")
    fun getActiveUserById(@PathVariable id: Int): ResponseEntity<BaseResponse<ResGetUserDto>>
}