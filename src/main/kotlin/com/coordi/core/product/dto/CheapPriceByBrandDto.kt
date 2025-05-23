package com.coordi.core.product.dto

import com.coordi.core.brand.domain.Brand
import com.coordi.core.global.costants.Category

data class CheapPriceByBrandDto(
    val category: Category,
    val brandName: String,
    val price: Int,
)
