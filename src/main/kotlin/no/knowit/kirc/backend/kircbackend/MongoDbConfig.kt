package no.knowit.kirc.backend.kircbackend

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.ArrayList
import java.util.Locale


@Configuration
class MongoDbConfig {


    @Bean
    fun customConversions(): MongoCustomConversions {
        val converters: MutableList<Converter<*, *>> = ArrayList()
        converters.add(ZonedDateTimeReadConverter())
        return MongoCustomConversions(converters)
    }
}

class ZonedDateTimeReadConverter : Converter<String, ZonedDateTime> {
    val dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD'T'kk:mm:ss.SSSSSS", Locale.getDefault())

    override fun convert(date: String): ZonedDateTime {
        return ZonedDateTime.parse(date, dtf)
    }

}