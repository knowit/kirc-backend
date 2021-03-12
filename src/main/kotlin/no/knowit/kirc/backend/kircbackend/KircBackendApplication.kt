package no.knowit.kirc.backend.kircbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KircBackendApplication

fun main(args: Array<String>) {
	runApplication<KircBackendApplication>(*args)
}
