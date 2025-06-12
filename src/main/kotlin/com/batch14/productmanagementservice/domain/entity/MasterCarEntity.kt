package com.batch14.productmanagementservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Entity
@Table(name = "mst_cars")
class MasterCarEntity(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator ="mst_cars_id_seq"
    )
    @SequenceGenerator(
        name = "mst_cars_id_seq",
        sequenceName = "mst_cars_id_seq",
        allocationSize = 1
    )
    @Column(name = "id", insertable = false, updatable = false)
    var id: Int = 0,

    @Column(name = "name")
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandId")
    var brand: MasterBrandEntity? = null,

    @Column(name = "created_by")
    var createdBy: String? = null,

    @CreationTimestamp
    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: Timestamp? = null,

    @Column(name = "updated_by")
    var updatedBy: String? = null,

    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: Timestamp? = null,

    @Column(name = "deleted_at")
    var deletedAt: Timestamp? = null,

    @Column(name = "deleted_by")
    var deletedBy: String? = null,

    @Column(name = "is_active")
    var isActive: Boolean = true,

    @Column(name = "is_delete")
    var isDelete: Boolean = false
)