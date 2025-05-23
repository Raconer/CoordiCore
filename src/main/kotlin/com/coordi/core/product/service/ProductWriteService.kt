package com.coordi.core.product.service

import com.coordi.core.product.dto.request.AddProductRequest
import com.coordi.core.product.dto.request.UpdateProductRequest

interface ProductWriteService {
    fun addProduct(addProductRequest: AddProductRequest): Boolean
    fun updateProduct(updateProductRequest: UpdateProductRequest): Boolean
    fun deleteProduct(id: Long): Boolean
}