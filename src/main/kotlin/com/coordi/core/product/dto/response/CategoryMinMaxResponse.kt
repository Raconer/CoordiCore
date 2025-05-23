package com.coordi.core.product.dto.response

import com.coordi.core.global.costants.Category
import com.coordi.core.product.dto.BrandPriceDto

data class CategoryMinMaxResponse(
    val category: Category,
    val cheapest: List<BrandPriceDto>,
    val mostExpensive: List<BrandPriceDto>
)
