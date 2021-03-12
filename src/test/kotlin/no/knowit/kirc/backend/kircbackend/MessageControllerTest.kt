package no.knowit.kirc.backend.kircbackend

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MessageControllerTest {

    private val messageController = MessageController()

    @Test
    fun getMessages() {
        val messages = messageController.getMessages()
        assertTrue(messages.isNotEmpty())
    }
}