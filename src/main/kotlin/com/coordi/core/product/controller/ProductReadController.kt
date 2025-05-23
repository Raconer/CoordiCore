package com.coordi.core.product.controller

import com.coordi.core.global.costants.Category
import com.coordi.core.global.response.CommonRes
import com.coordi.core.product.service.ProductReadService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductReadController(
    private val productReadService: ProductReadService
) {

    @Operation(
        summary = "카테고리별 최저가 브랜드 및 상품 가격 조회",
        description = """
        각 카테고리(상의, 아우터, 바지 등)별로 
        최저 가격을 가진 브랜드와 해당 가격 정보를 반환합니다.
        
        총 8개 카테고리의 결과를 포함하며, 
        마지막에 총합 가격(totalPrice)도 함께 반환합니다.
        
        ※ 요청값은 없으며, 실패 시 에러 메시지를 반환합니다.
    """
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "카테고리별 최저가 조회 성공"),
            ApiResponse(responseCode = "500", description = "서버 오류 또는 처리 실패")
        ]
    )
    @GetMapping("/categoryWiseCheapBrands")
    fun getCategoryWiseCheapBrands(): ResponseEntity<out Any> {
        val data = this.productReadService.getCategoryWiseCheapBrands()
        return CommonRes.Def(data)
    }

    @Operation(
        summary = "단일 브랜드 기준 최저가 조회",
        description = """
        하나의 브랜드에서 모든 카테고리(상의, 아우터, 바지 등)의 상품을 구매할 경우, 
        총합 가격이 가장 낮은 브랜드와 해당 브랜드의 각 상품 가격 및 총액을 조회합니다.
        
        요청값은 없으며, 총액 기준으로 가장 저렴한 브랜드 한 개만 반환합니다.
    """
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "단일 브랜드 기준 최저가 조회 성공"),
            ApiResponse(responseCode = "500", description = "서버 오류 또는 처리 실패")
        ]
    )
    @GetMapping("/cheapestTotalByBrand")
    fun getCheapestTotalByBrand(): ResponseEntity<out Any> {
        val data = this.productReadService.getCheapestTotalByBrand()
        return CommonRes.Def(data)
    }


    @Operation(
        summary = "카테고리별 최저/최고가 브랜드 조회",
        description = """
        특정 카테고리를 기준으로, 최저가와 최고가인 브랜드의 이름과 해당 가격을 반환합니다.
        
        예: 상의 카테고리에 대해 가장 저렴한 브랜드와 가장 비싼 브랜드의 가격 비교.
    """
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "카테고리 기준 최저/최고가 조회 성공"),
            ApiResponse(responseCode = "400", description = "존재하지 않는 카테고리명"),
            ApiResponse(responseCode = "500", description = "서버 오류 또는 처리 실패")
        ]
    )
    @GetMapping("/minMaxPriceByCategory")
    fun getMinMaxPriceByCategory(
        @RequestParam category: Category
    ): ResponseEntity<out Any> {
        val data = this.productReadService.getMinMaxPriceByCategory(category)

        return CommonRes.Def(data)
    }

}