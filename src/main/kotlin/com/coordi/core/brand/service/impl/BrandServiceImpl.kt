package com.coordi.core.brand.service.impl

import com.coordi.core.brand.domain.Brand
import com.coordi.core.brand.domain.UpdateBrandRequest
import com.coordi.core.brand.dto.request.AddBrandRequest
import com.coordi.core.brand.repository.BrandRepository
import com.coordi.core.brand.service.BrandService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BrandServiceImpl(
    private val brandRepository: BrandRepository
) : BrandService {
    @Transactional
    override fun addBrand(addBrandRequest: AddBrandRequest): Boolean {
        val brand = Brand(addBrandRequest)
        this.brandRepository.save(brand)
        return true
    }
    @Transactional
    override fun updateBrand(updateBrandRequest: UpdateBrandRequest): Boolean {
        val brand = Brand(updateBrandRequest)
        this.brandRepository.save(brand)
        return true
    }
    @Transactional
    override fun deleteBrand(id: Long): Boolean {
        this.brandRepository.deleteById(id)
        return true
    }

}