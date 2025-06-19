package com.batch14.productmanagementservice.repository

import com.batch14.productmanagementservice.domain.entity.MasterCarEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface MasterCarRepository: JpaRepository<MasterCarEntity, Int> {
    @Query("""
        SELECT U FROM MasterCarEntity U
        WHERE U.name = :name
    """, nativeQuery = false)
    fun findFirstByName(name: String): Optional<MasterCarEntity>
}