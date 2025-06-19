package com.batch14.productmanagementservice.domain.dto.response

class ResGetUsersDto (
    val id: Int,
    val email: String,
    val username: String,
    var roleId: Int? = null
)