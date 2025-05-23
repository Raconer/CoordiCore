package com.coordi.core.product.service.impl

import com.coordi.core.brand.repository.BrandRepository
import com.coordi.core.product.domain.Product
import com.coordi.core.product.dto.request.AddProductRequest
import com.coordi.core.product.dto.request.UpdateProductRequest
import com.coordi.core.product.repository.ProductWriteRepository
import com.coordi.core.product.service.ProductWriteService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductWriteServiceImpl(
    private val brandRepository: BrandRepository,
    private val productWriteRepository: ProductWriteRepository
) : ProductWriteService {
    @Transactional
    override fun addProduct(addProductRequest: AddProductRequest) : Boolean{

        this.brandRepository.findByIdOrNull(addProductRequest.brandId)?.let {
            val product = Product(it, addProductRequest)
            this.productWriteRepository.save(product)
            return true
        }

        return false
    }

    @Transactional
    override fun updateProduct(updateProductRequest: UpdateProductRequest): Boolean {
        val product = Product(updateProductRequest)

        updateProductRequest.brandId?.let {
            product.brand = this.brandRepository.findByIdOrNull(it)!!
        }

        this.productWriteRepository.save(product)

        return true
    }


    @Transactional
    override fun deleteProduct(id:Long) : Boolean{
        this.productWriteRepository.deleteById(id)
        return true
    }
}