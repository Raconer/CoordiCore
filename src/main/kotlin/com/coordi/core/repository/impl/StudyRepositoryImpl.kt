package com.coordi.core.repository.impl

import com.coordi.core.domain.QStudy
import com.coordi.core.domain.Study
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class StudyRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : StudyRepositoryCustom {
    override fun findAll(): MutableList<Study> {
        val study = QStudy.study
        return this.jpaQueryFactory.selectFrom(study).fetch()
    }
}