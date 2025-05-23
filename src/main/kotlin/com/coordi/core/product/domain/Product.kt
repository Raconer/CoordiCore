package com.coordi.core.product.domain

import com.coordi.core.brand.domain.Brand
import com.coordi.core.global.costants.Category
import com.coordi.core.product.dto.request.AddProductRequest
import com.coordi.core.product.dto.request.UpdateProductRequest
import jakarta.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    var brand: Brand? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val category: Category? = null,

    @Column(nullable = false)
    val price: Int? = null
){
    constructor(brand: Brand,
                productRequest: AddProductRequest): this(brand = brand, category = productRequest.category, price = productRequest.price)

    constructor(productRequest: UpdateProductRequest): this(id = productRequest.id, category = productRequest.category, price = productRequest.price)
}
