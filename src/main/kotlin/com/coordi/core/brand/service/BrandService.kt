package com.coordi.core.brand.service

import com.coordi.core.brand.domain.UpdateBrandRequest
import com.coordi.core.brand.dto.request.AddBrandRequest

interface BrandService {
    fun addBrand(addBrandRequest: AddBrandRequest): Boolean
    fun updateBrand(updateBrandRequest: UpdateBrandRequest): Boolean
    fun deleteBrand(id: Long): Boolean
}