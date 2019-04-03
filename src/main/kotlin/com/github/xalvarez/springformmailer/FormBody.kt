package com.github.xalvarez.springformmailer

import com.github.xalvarez.springformmailer.mailgun.MailgunPayload
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
) {

    fun toMailgunPayload() = MailgunPayload(name, amountOfAdditionalAdults, amountOfAdditionalChildren, comments)
}