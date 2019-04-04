package com.github.xalvarez.springformmailer.mailgun

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
    lateinit var sender: String

    @NotEmpty
    lateinit var domain: String

    val mailgunEndpointUrl: String by lazy { "https://api.mailgun.net/v3/$domain/messages" }

    @NotNull
    @Value("\${mailgun.email.recipients}")
    lateinit var recipients: Array<String>

    @NotEmpty
    lateinit var apiKey: String

}