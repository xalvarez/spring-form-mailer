package com.github.xalvarez.springformmailer

import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

data class FormBody(

    @NotEmpty
    private val name: String,

    @Min(0)
    private val amountOfAdditionalAdults: Int,

    @Min(0)
    private val amountOfAdditionalChildren: Int,

    private val additionalInformation: String
)