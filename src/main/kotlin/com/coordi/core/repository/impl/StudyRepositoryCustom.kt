package com.coordi.core.repository.impl

import com.coordi.core.domain.Study

interface StudyRepositoryCustom {
    fun findAll(): MutableList<Study>
}