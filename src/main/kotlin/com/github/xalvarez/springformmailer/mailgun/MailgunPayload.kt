package com.github.xalvarez.springformmailer.mailgun

data class MailgunPayload(
    val name: String,
    val amountOfAdditionalAdults: Int,
    val amountOfAdditionalChildren: Int,
    val comments: String
)