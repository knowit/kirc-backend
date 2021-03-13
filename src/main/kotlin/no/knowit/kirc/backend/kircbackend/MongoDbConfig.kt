package no.knowit.kirc.backend.kircbackend

import com.mongodb.lang.Nullable
import org.bson.Document
import org.bson.json.Converter
import org.bson.json.StrictJsonWriter
import java.time.ZonedDateTime

import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component
import java.util.Date


@Component
@WritingConverter
class ZonedDateTimeToDocumentConverter : Converter<ZonedDateTime> {
    fun convert(@Nullable zonedDateTime: ZonedDateTime): Document {
        val document = Document()
        document[DATE_TIME] = Date.from(zonedDateTime.toInstant())
        document[ZONE] = zonedDateTime.zone.id
        document["offset"] = zonedDateTime.offset.toString()
        return document
    }

    companion object {
        const val DATE_TIME = "dateTime"
        const val ZONE = "zone"
    }

    override fun convert(value: ZonedDateTime, writer: StrictJsonWriter) {

    }
}