package com.coordi.core.brand.service.impl

import com.coordi.core.brand.domain.Brand
import com.coordi.core.brand.dto.request.UpdateBrandRequest
import com.coordi.core.brand.dto.request.AddBrandRequest
import com.coordi.core.brand.repository.BrandRepository
import com.coordi.core.brand.service.BrandWriteService
import com.coordi.core.product.repository.ProductWriteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BrandWriteServiceImpl(
    private val brandRepository: BrandRepository,
    private val productWriteRepository: ProductWriteRepository
) : BrandWriteService {
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