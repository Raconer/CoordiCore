package com.coordi.core.controller

import com.coordi.core.service.StudyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StudyController (
    private val studyService: StudyService
){
    @GetMapping
    fun get():String{
        // JPA
        val jpaData =  this.studyService.findAll()
        println(jpaData)
        // QueryDSL
        val queryData = this.studyService.findAllByQueryDSL()
        println(queryData)

        return "Success"
    }
}