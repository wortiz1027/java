package co.com.microservice

import org.reactivestreams.Publisher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController("/")
class MyService {

    @GetMapping("saludo/{nombre}/{apellido}")
    @ResponseBody
    fun saludo(@PathVariable nombre: String, @PathVariable apellido: String) : Publisher<String> {
        return Mono.just("Hola Mundo $nombre $apellido")
    }

}

