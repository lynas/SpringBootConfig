package com.lynas

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ApplicationStarter

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationStarter::class.java, *args)
}
