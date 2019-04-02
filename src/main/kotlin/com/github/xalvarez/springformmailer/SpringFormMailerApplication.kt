package com.github.xalvarez.springformmailer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringFormMailerApplication

fun main(args: Array<String>) {
    runApplication<SpringFormMailerApplication>(*args)
}