package com.coordi.core.service

import com.coordi.core.domain.Study
import com.coordi.core.repository.StudyRepository
import com.coordi.core.repository.impl.StudyRepositoryCustom
import com.coordi.core.repository.impl.StudyRepositoryImpl
import org.springframework.stereotype.Service

@Service
class StudyService (
    private val studyRepository: StudyRepository,
    private val studyRepositoryCustom: StudyRepositoryCustom
){
    fun findAll(): List<Study> = this.studyRepository.findAll()

    fun findAllByQueryDSL():List<Study> = this.studyRepositoryCustom.findAll()
}