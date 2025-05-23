package com.coordi.core.product.dto.request

import com.coordi.core.brand.domain.Brand
import com.coordi.core.global.costants.Category
import jakarta.persistence.*

data class AddProductRequest(
    val brandId: Long,
    val category: Category,
    val price: Int
)
