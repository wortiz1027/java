package co.com.microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
@ComponentScan
class HellowordserviceApplication

fun main(args: Array<String>) {
    runApplication<HellowordserviceApplication>(*args)
}
