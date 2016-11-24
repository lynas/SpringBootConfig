package com.lynas

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class EomsBotApplication

fun main(args: Array<String>) {
    SpringApplication.run(EomsBotApplication::class.java, *args)
}
