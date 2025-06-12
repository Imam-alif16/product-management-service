package com.batch14.productmanagementservice.repository

import com.batch14.productmanagementservice.domain.entity.MasterBrandEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MasterBrandRepository: JpaRepository<MasterBrandEntity, Int> {
}