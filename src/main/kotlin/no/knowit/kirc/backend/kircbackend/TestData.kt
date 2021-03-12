package no.knowit.kirc.backend.kircbackend

import no.knowit.kirc.api.Message
import java.time.ZonedDateTime
import java.util.UUID
import com.thedeanda.lorem.LoremIpsum

import com.thedeanda.lorem.Lorem
import kotlin.random.Random


object TestData {
    var lorem: Lorem = LoremIpsum.getInstance()

    fun createMessage(): Message {
        return Message(
                id = UUID.randomUUID(),
                timestamp = ZonedDateTime.now(),
                message = lorem.getWords(Random.nextInt(100))
        )
    }
}