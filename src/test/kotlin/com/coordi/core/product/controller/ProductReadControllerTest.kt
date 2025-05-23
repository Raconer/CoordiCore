package com.coordi.core.product.controller

import com.coordi.core.brand.dto.request.AddBrandRequest
import com.coordi.core.util.ConverterUtil
import net.datafaker.Faker
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@SpringBootTest
@AutoConfigureMockMvc
class ProductReadControllerTest  @Autowired constructor(
private val mockMvc: MockMvc,
) {
    private val PATH: String = "/products"
    private val faker = Faker()
    @Test
    @DisplayName("카테고리별 최저가 브랜드 및 상품 가격 조회 테스트")
    fun getCategoryWiseCheapBrands() {
        // GIVEN

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.get("${this.PATH}/categoryWiseCheapBrands")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @DisplayName("단일 브랜드 기준 최저가 조회 테스트")
    fun getCheapestTotalByBrand() {
        // GIVEN
        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.get("${this.PATH}/cheapestTotalByBrand")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @DisplayName("카테고리별 최저/최고가 브랜드 조회 테스트")
    fun getMinMaxPriceByCategory() {
        // GIVEN

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.get("${this.PATH}/minMaxPriceByCategory?category=TOP")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}