package com.github.xalvarez.springformmailer.mailgun

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Configuration
@ConfigurationProperties(prefix = MAILGUN_CONFIGURATION_PREFIX)
class MailgunConfiguration {

    @Email
    @Value("\${mailgun.email.sender}")
    lateinit var sender: String

    @NotBlank
    lateinit var baseUrl: String

    @NotNull
    @Value("\${mailgun.email.recipients}")
    lateinit var recipients: Array<String>

    @NotBlank
    lateinit var apiKey: String
}

private const val MAILGUN_CONFIGURATION_PREFIX = "mailgun"