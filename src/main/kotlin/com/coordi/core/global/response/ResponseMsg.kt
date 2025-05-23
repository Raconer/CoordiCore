package com.coordi.core.global.response

import java.time.LocalDate

data class ResponseMsg(
    val date: LocalDate = LocalDate.now(),
    var result: Any? = null
)