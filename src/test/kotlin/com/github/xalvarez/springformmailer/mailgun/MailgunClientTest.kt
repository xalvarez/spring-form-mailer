package com.github.xalvarez.springformmailer.mailgun

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.github.xalvarez.springformmailer.SpringFormMailerApplicationTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringRunner
import javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import javax.servlet.http.HttpServletResponse.SC_OK
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@SpringFormMailerApplicationTest
@RunWith(SpringRunner::class)
class MailgunClientTest {

    @Autowired
    private lateinit var mailgunClient: MailgunClient

    @get:Rule
    var wireMockRule = WireMockRule(WIREMOCK_PORT)

    @Test
    fun `should send e-mail`() {
        val mailgunPayload = givenMailgunPayload()
        givenPositiveMailgunResponse()

        val hasEmailBeenSent = whenSendingEmail(mailgunPayload)

        assertTrue(hasEmailBeenSent)
    }

    @Test
    fun `should return error on failed e-mail delivery`() {
        val mailgunPayload = givenMailgunPayload()
        givenNegativeMailgunResponse()

        val hasEmailBeenSent = whenSendingEmail(mailgunPayload)

        assertFalse(hasEmailBeenSent)
    }

    private fun givenMailgunPayload() = MailgunPayload(
        name = "Joe Doe",
        amountOfAdditionalAdults = 2,
        amountOfAdditionalChildren = 0,
        comments = "Let's have fun!"
    )

    private fun givenPositiveMailgunResponse() {
        stubFor(post(anyUrl()).willReturn(aResponse().withStatus(SC_OK)))
    }

    private fun givenNegativeMailgunResponse() {
        stubFor(post(anyUrl()).willReturn(aResponse().withStatus(SC_BAD_REQUEST)))
    }

    private fun whenSendingEmail(mailgunPayload: MailgunPayload) = mailgunClient.sendEmail(mailgunPayload)

}

private const val WIREMOCK_PORT = 18080