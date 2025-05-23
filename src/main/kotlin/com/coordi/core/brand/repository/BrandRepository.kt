package com.coordi.core.brand.repository

import com.coordi.core.brand.domain.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository: JpaRepository<Brand, Long>