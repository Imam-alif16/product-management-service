package com.batch14.productmanagementservice.domain.dto.response

class ResGetCarDto (
    val id: Int,
    val name: String,
    val brandId: Int?,
    val createdBy: String? = null
)