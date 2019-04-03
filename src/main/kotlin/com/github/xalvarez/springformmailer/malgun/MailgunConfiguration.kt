package com.github.xalvarez.springformmailer.malgun

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Configuration
@ConfigurationProperties(prefix = "mailgun")
class MailgunConfiguration {

    @Email
    @Value("\${mailgun.email.sender}")
    private lateinit var sender: String

    @NotEmpty
    private lateinit var domain: String

    private val mailgunEndpointUrl: String by lazy { "https://api.mailgun.net/v3/$domain/messages" }

    @NotNull
    @Value("\${mailgun.email.recipients}")
    private lateinit var recipients: Array<String>

    @NotEmpty
    private lateinit var apiKey: String

}