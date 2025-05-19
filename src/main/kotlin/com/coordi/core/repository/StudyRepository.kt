package com.coordi.core.repository

import com.coordi.core.domain.Study
import org.springframework.data.jpa.repository.JpaRepository

interface StudyRepository : JpaRepository<Study, Long> {
}