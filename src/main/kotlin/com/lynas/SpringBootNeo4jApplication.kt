package com.lynas

import com.lynas.config.InterceptorConfig
import org.apache.log4j.Logger
import org.neo4j.ogm.config.Configuration
import org.springframework.beans.factory.InjectionPoint
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
open class SpringBootNeo4jApplication(val interceptorConfig: InterceptorConfig) : WebMvcConfigurerAdapter() {
    @Bean
    open fun getConfiguration(): Configuration {
        val config = Configuration()
        config
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver").uri = "http://neo4j:123456@localhost:7474"
        return config
    }


    @Bean
    @Scope("prototype")
    open fun logger(injectionPoint: InjectionPoint): Logger {
        return Logger.getLogger(injectionPoint.member.declaringClass)
    }


    override fun addInterceptors(registry: InterceptorRegistry?) {
        super.addInterceptors(registry)
        registry?.addInterceptor(interceptorConfig)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootNeo4jApplication::class.java, *args)
}


object AppConstant {
    val organization = "ORGANIZATION"
}