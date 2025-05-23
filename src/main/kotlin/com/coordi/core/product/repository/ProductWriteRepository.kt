package com.coordi.core.product.repository

import com.coordi.core.product.domain.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductWriteRepository : JpaRepository<Product, Long> {
}