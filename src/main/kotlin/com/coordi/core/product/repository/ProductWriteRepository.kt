package com.coordi.core.product.repository

import com.coordi.core.brand.domain.Brand
import com.coordi.core.product.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity

interface ProductWriteRepository : JpaRepository<Product, Long> {
    fun deleteByBrandId(brandId: Long)
}