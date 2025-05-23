package com.coordi.core.product.controller

import com.coordi.core.brand.dto.request.AddBrandRequest
import com.coordi.core.brand.dto.request.UpdateBrandRequest
import com.coordi.core.global.costants.Category
import com.coordi.core.product.dto.request.AddProductRequest
import com.coordi.core.product.dto.request.UpdateProductRequest
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

@SpringBootTest
@AutoConfigureMockMvc
class ProductWriteControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {
    private val PATH: String = "/products"
    private val faker = Faker()
    @Test
    @DisplayName("상품 추가 테스트")
    fun addProduct() {
        // GIVEN
        val addProductRequest = AddProductRequest(1,Category.BAG, 1000)
        val jsonBody:String = ConverterUtil.getJsonString(addProductRequest)!!

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.post(this.PATH)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonBody)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @DisplayName("상품 수정 테스트")
    fun updateProduct() {
        // GIVEN
        val addProductRequest = UpdateProductRequest(1,1,Category.BAG, 1000)
        val jsonBody:String = ConverterUtil.getJsonString(addProductRequest)!!

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.put(this.PATH)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonBody)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @DisplayName("상품 삭제 테스트")
    fun deleteProduct() {
        // GIVEN

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.delete("${this.PATH}/1")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}