package com.github.xalvarez.springformmailer

import com.github.xalvarez.springformmailer.mailgun.MailgunClient
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class IndexController(private val mailgunClient: MailgunClient) {

    @GetMapping("")
    fun index(formBody: FormBody) = "index"

    @PostMapping("/submit")
    fun submit(@Valid formBody: FormBody, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors())
            return "index"

        return if (mailgunClient.sendEmail(formBody.toMailgunPayload())) "success" else "error"
    }
}