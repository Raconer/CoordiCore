package com.coordi.core.product.controller

import com.coordi.core.global.response.CommonRes
import com.coordi.core.product.domain.Product
import com.coordi.core.product.dto.request.AddProductRequest
import com.coordi.core.product.dto.request.UpdateProductRequest
import com.coordi.core.product.service.ProductWriteService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductWriteController(
    private val productWriteService: ProductWriteService
) {

    @Operation(
        summary = "상품 등록",
        description = "상품을 브랜드 ID와 함께 등록합니다. 브랜드 ID가 존재해야 합니다."
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "상품 등록 성공"),
            ApiResponse(responseCode = "400", description = "입력값 오류"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
    @PostMapping
    fun addProduct(@RequestBody request: AddProductRequest): ResponseEntity<out Any> {
        this.productWriteService.addProduct(request)
        return CommonRes.Basic(HttpStatus.OK)
    }

    @Operation(
        summary = "상품 정보 수정",
        description = "상품 ID를 기반으로 카테고리 및 가격 정보를 수정합니다."
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "상품 수정 성공"),
            ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
    @PutMapping
    fun updateProduct(
        @RequestBody request: UpdateProductRequest
    ): ResponseEntity<out Any> {
        this.productWriteService.updateProduct(request)
        return CommonRes.Basic(HttpStatus.OK)
    }

    @Operation(
        summary = "상품 삭제",
        description = "상품 ID를 기준으로 상품을 삭제합니다."
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "상품 삭제 성공"),
            ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<out Any>  {
        this.productWriteService.deleteProduct(id)
        return CommonRes.Basic(HttpStatus.OK)
    }
}