package com.github.xalvarez.springformmailer

import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class IndexController {

    @GetMapping
    fun index(formBody: FormBody?) = "index"

    @PostMapping("/submit")
    fun submit(@Valid formBody: FormBody, bindingResult: BindingResult): String {
        return if (bindingResult.hasErrors()) "index" else "index"
    }

}