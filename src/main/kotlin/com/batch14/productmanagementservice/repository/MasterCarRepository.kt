package com.batch14.productmanagementservice.repository

import com.batch14.productmanagementservice.domain.entity.MasterCarEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MasterCarRepository: JpaRepository<MasterCarEntity, Int> {
}