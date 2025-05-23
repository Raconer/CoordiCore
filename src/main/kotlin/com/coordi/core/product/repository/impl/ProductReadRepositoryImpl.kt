package com.coordi.core.product.repository.impl

import com.coordi.core.brand.domain.QBrand.brand
import com.coordi.core.global.costants.Category
import com.coordi.core.product.domain.QProduct.product
import com.coordi.core.product.dto.BrandCategoryPriceDto
import com.coordi.core.product.dto.BrandPriceDto

import com.coordi.core.product.dto.CheapPriceByBrandDto
import com.querydsl.core.types.ExpressionUtils
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ProductReadRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
){
    fun findCategoryWiseCheapBrands():List<CheapPriceByBrandDto>{
        val sub = this.jpaQueryFactory
            .select(product.category, product.price.min())
            .from(product)
            .groupBy(product.category)

        return this.jpaQueryFactory
            .select(
                Projections.constructor(
                    CheapPriceByBrandDto::class.java,
                    product.category,
                    brand.name,
                    product.price
                )
            )
            .from(product)
            .join(product.brand, brand)
            .where(
                ExpressionUtils.`in`(
                    Expressions.list(product.category, product.price),
                    sub
                )
            )
            .fetch()
    }

    fun findCheapestTotalByBrand():Triple< String, List<BrandCategoryPriceDto>, Int>{
        // 1. 가장 저렴한 단일 브랜드 ID 구하기 (모든 카테고리 포함)
        val cheapestBrandId = this.jpaQueryFactory
            .select(product.brand.id)
            .from(product)
            .groupBy(product.brand.id)
            .having(product.category.countDistinct().eq(8))
            .orderBy(product.price.sum().asc())
            .limit(1)
            .fetchOne() ?: throw IllegalStateException("최저가 브랜드 없음")

        // 2. 해당 브랜드의 카테고리별 상품과 가격 가져오기
        val productList = this.jpaQueryFactory
            .select(
                Projections.constructor(
                    BrandCategoryPriceDto::class.java,
                    product.category,
                    product.price
                )
            )
            .from(product)
            .where(product.brand.id.eq(cheapestBrandId))
            .fetch()

        // 3. 브랜드 이름과 총합 계산
        val brandName = this.jpaQueryFactory
            .select(brand.name)
            .from(brand)
            .where(brand.id.eq(cheapestBrandId))
            .fetchOne() ?: "Unknown"

        val totalPrice = productList.sumOf { it.price }

        return Triple( brandName, productList, totalPrice)
    }

    fun findMinMaxPriceByCategory(category: Category): Pair<List<BrandPriceDto>, List<BrandPriceDto>> {
        // 최저 가격
        val minPrice = this.jpaQueryFactory
            .select(product.price.min())
            .from(product)
            .where(product.category.eq(category))
            .fetchOne() ?: throw IllegalStateException("카테고리 없음")

        // 최고 가격
        val maxPrice = this.jpaQueryFactory
            .select(product.price.max())
            .from(product)
            .where(product.category.eq(category))
            .fetchOne() ?: throw IllegalStateException("카테고리 없음")

        // 최저가 브랜드 목록
        val minList = this.jpaQueryFactory
            .select(
                Projections.constructor(
                    BrandPriceDto::class.java,
                    brand.name,
                    product.price
                )
            )
            .from(product)
            .join(product.brand, brand)
            .where(
                product.category.eq(category),
                product.price.eq(minPrice)
            )
            .fetch()

        // 최고가 브랜드 목록
        val maxList = this.jpaQueryFactory
            .select(
                Projections.constructor(
                    BrandPriceDto::class.java,
                    brand.name,
                    product.price
                )
            )
            .from(product)
            .join(product.brand, brand)
            .where(
                product.category.eq(category),
                product.price.eq(maxPrice)
            )
            .fetch()

        return Pair(minList, maxList)
    }
}