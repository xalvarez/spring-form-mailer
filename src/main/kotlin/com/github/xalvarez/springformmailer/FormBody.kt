package com.github.xalvarez.springformmailer

import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

data class FormBody(

    @field:NotEmpty
    var name: String = "",

    @field:Min(0)
    var amountOfAdditionalAdults: Int = 0,

    @field:Min(0)
    var amountOfAdditionalChildren: Int = 0,

    var comments: String = ""
)