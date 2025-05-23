package com.coordi.core.brand.domain

import com.coordi.core.brand.dto.request.AddBrandRequest
import com.coordi.core.brand.dto.request.UpdateBrandRequest
import com.coordi.core.product.domain.Product
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "brand")
data class Brand (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val name: String? = null,

    @OneToMany(mappedBy = "brand", cascade = [CascadeType.ALL], orphanRemoval = false)
    val products: MutableList<Product> = mutableListOf()
){
    constructor(addBrandRequest: AddBrandRequest):this(name = addBrandRequest.name)
    constructor(updateBrandRequest: UpdateBrandRequest):this(id = updateBrandRequest.id, name = updateBrandRequest.name)
}