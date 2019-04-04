package com.github.xalvarez.springformmailer

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.annotation.AliasFor
import org.springframework.test.context.ActiveProfiles

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@SpringBootTest
@ActiveProfiles
annotation class SpringFormMailerApplicationTest(

    @get:AliasFor(annotation = ActiveProfiles::class, attribute = "profiles")
    val activeProfiles: Array<String> = ["test"],

    @get:AliasFor(annotation = SpringBootTest::class, attribute = "properties")
    val properties: Array<String> = []
)