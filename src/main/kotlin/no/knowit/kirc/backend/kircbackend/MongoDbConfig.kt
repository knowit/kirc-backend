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
    var dateTimeFormatter = DateTimeFormatter.ofPattern("[yyyyMMdd][yyyy-MM-dd][yyyy-DDD]['T'[HHmmss][HHmm][HH:mm:ss][HH:mm][.SSSSSSS][.SSSSSS][.SSSSS][.SSSS][.SSS][.SS][.S]][XXX][XX][X]", Locale.getDefault())


    override fun convert(date: String): ZonedDateTime {
        return ZonedDateTime.parse(date, dateTimeFormatter)
    }

}