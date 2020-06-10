package com.github.xalvarez.springformmailer.mailgun

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.reactive.function.client.WebClient.create
import org.springframework.web.reactive.function.client.WebClientException

@Component
class MailgunClient(val mailgunConfiguration: MailgunConfiguration) {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    fun sendEmail(mailgunPayload: MailgunPayload): Boolean {
        try {
            val responseBody = create()
                .post()
                .uri(mailgunConfiguration.baseUrl)
                .contentType(APPLICATION_FORM_URLENCODED)
                .syncBody(buildFormData(mailgunPayload))
                .headers { it.setBasicAuth("api", mailgunConfiguration.apiKey) }
                .retrieve()
                .bodyToMono(String::class.java)
                .block()
            log.info("E-mail submission was successful. Response body: '$responseBody'")
            return true
        } catch (exception: WebClientException) {
            log.error("E-mail submission failed.");
            return false
        }
    }

    private fun buildFormData(mailgunPayload: MailgunPayload): LinkedMultiValueMap<String, String> {
        val formData: LinkedMultiValueMap<String, String> = LinkedMultiValueMap()
        formData.add("from", mailgunConfiguration.sender)
        mailgunConfiguration.recipients.forEach { formData.add("to", it) }
        formData.add("subject", "New data has been submitted")
        formData.add(
            "text", """
            ${mailgunPayload.name} has submitted the following data:
            Amount of additional adults: ${mailgunPayload.amountOfAdditionalAdults}
            Amount of additional children: ${mailgunPayload.amountOfAdditionalChildren}
            Comments: ${mailgunPayload.comments}
        """.trimIndent()
        )

        return formData
    }
}