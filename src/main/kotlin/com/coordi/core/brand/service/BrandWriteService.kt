package com.coordi.core.brand.service

import com.coordi.core.brand.dto.request.UpdateBrandRequest
import com.coordi.core.brand.dto.request.AddBrandRequest

interface BrandWriteService {
    fun addBrand(addBrandRequest: AddBrandRequest): Boolean
    fun updateBrand(updateBrandRequest: UpdateBrandRequest): Boolean
    fun deleteBrand(id: Long): Boolean
}