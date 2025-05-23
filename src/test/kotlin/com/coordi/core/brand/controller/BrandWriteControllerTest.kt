package com.coordi.core.brand.controller

import com.coordi.core.brand.domain.Brand
import com.coordi.core.brand.dto.request.AddBrandRequest
import com.coordi.core.brand.dto.request.UpdateBrandRequest
import com.coordi.core.product.domain.Product
import com.coordi.core.util.ConverterUtil
import net.datafaker.Faker
import org.hibernate.sql.Update
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
class BrandWriteControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {
    private val PATH: String = "/brand"
    private val faker = Faker()


    @Test
    @DisplayName("브랜드 추가 테스트")
    fun addBrand() {
        // GIVEN
        val addBrandRequest = AddBrandRequest(faker.name().name())
        val jsonBody:String = ConverterUtil.getJsonString(addBrandRequest)!!

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.post(this.PATH)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonBody)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @DisplayName("브랜드 수정 테스트")
    fun updateBrand() {
        // GIVEN
        val addBrandRequest = UpdateBrandRequest(1,faker.name().name())
        val jsonBody:String = ConverterUtil.getJsonString(addBrandRequest)!!

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.put(this.PATH)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonBody)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @DisplayName("브랜드 삭제 테스트")
    fun deleteBrand() {
        // GIVEN

        // WHEN & THEN
        mockMvc.perform(
            MockMvcRequestBuilders.delete("${this.PATH}/1")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}