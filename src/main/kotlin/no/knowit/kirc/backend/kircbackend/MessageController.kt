package no.knowit.kirc.backend.kircbackend

import no.knowit.kirc.api.Message
import no.knowit.kirc.api.MessagesApiService

class MessageController: MessagesApiService {

    override fun getMessages(): List<Message> {
        return (1..100).map { TestData.createMessage() }
    }
}