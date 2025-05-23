package com.coordi.core.product.service.impl

import com.coordi.core.global.costants.Category
import com.coordi.core.product.dto.BrandCategoryPriceDto
import com.coordi.core.product.dto.BrandPriceDto
import com.coordi.core.product.dto.CheapPriceByBrandDto
import com.coordi.core.product.repository.impl.ProductReadRepositoryImpl
import com.coordi.core.product.service.ProductReadService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProductReadServiceImpl(
    private val productReadRepositoryImpl: ProductReadRepositoryImpl
) : ProductReadService {

    override fun getCategoryWiseCheapBrands() : List<CheapPriceByBrandDto>{
        return this.productReadRepositoryImpl.findCategoryWiseCheapBrands()
    }

    override fun getCheapestTotalByBrand(): Triple<String, List<BrandCategoryPriceDto>, Int> {
        return this.productReadRepositoryImpl.findCheapestTotalByBrand()
    }

    override fun getMinMaxPriceByCategory(category: Category): Pair<List<BrandPriceDto>, List<BrandPriceDto>> {
        return this.productReadRepositoryImpl.findMinMaxPriceByCategory(category)
    }

}