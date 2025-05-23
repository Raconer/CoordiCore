package com.coordi.core.product.service

import com.coordi.core.global.costants.Category
import com.coordi.core.product.dto.BrandCategoryPriceDto
import com.coordi.core.product.dto.BrandPriceDto
import com.coordi.core.product.dto.CheapPriceByBrandDto


interface ProductReadService {
    fun getCategoryWiseCheapBrands():List<CheapPriceByBrandDto>
    fun getCheapestTotalByBrand(): Triple< String, List<BrandCategoryPriceDto>, Int>
    fun getMinMaxPriceByCategory(category:Category):Pair<List<BrandPriceDto>, List<BrandPriceDto>>
}


