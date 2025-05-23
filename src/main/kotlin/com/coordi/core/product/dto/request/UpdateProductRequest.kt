package com.coordi.core.product.dto.request

import com.coordi.core.global.costants.Category

data class UpdateProductRequest(
    val id:Long,
    val brandId:Long? = null,
    val category: Category? = null,
    val price: Int? = null
)
