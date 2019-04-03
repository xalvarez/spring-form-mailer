package com.github.xalvarez.springformmailer.mailgun

data class MailgunPayload(
    private val name: String,
    private val amountOfAdditionalAdults: Int,
    private val amountOfAdditionalChildren: Int,
    private val comments: String
)