package no.knowit.kirc.backend.kircbackend

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime

@Controller
class MainController(val messageService: MessageService) {

    @GetMapping("/")
    fun getIndex(model: Model): String {
        val messages = messageService.getLatestMessages()
        model.addAttribute("messages", messages)
        return "index"
    }
}