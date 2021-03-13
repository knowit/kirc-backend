package no.knowit.kirc.backend.kircbackend

import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import no.knowit.kirc.api.Message
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.UUID
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random


object TestData {
    var lorem: Lorem = LoremIpsum.getInstance()

    fun createMessage(): Message {
        return Message(
                id = UUID.randomUUID(),
                timestamp = LocalDateTime.now(),
                message = lorem.getWords(Random.nextInt(100))
        )
    }
}