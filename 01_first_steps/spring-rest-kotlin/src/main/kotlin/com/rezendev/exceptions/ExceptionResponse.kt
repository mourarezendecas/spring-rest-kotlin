package com.rezendev.exceptions

import java.util.Date

class ExceptionResponse(
    val timeStamp: Date,
    val message: String?,
    val details: String
)