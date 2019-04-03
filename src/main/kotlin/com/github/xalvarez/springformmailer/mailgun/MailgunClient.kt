package com.github.xalvarez.springformmailer.mailgun

import org.springframework.stereotype.Component

@Component
class MailgunClient(private val mailgunConfiguration: MailgunConfiguration) {

    fun sendEmail(mailgunPayload: MailgunPayload) {
        println("Hello World!")
    }
}