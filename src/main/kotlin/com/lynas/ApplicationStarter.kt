package com.lynas

import org.neo4j.ogm.config.Configuration
import org.springframework.boot.SpringApplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement




@EnableNeo4jRepositories
@EnableTransactionManagement
@SpringBootApplication
open class ApplicationStarter{
    @Bean
    open fun getConfiguration(): Configuration {
        val config = Configuration()
        config
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver").uri = "http://neo4j:123456@localhost:7474"
        return config
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationStarter::class.java, *args)
}
