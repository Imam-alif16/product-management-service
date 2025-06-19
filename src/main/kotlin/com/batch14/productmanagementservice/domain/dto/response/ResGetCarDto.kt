package com.batch14.productmanagementservice.domain.dto.response

import com.batch14.productmanagementservice.domain.entity.MasterBrandEntity

class ResGetCarDto (
    val id: Int,
    val name: String,
    val color: String,
    val brandId: Int? = null,
    val createdBy: String? = null
)