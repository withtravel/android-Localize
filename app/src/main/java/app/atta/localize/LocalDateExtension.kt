package app.atta.localize

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

const val DEFAULT_INPUT_TIME_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

fun LocalDate.isPast(): Boolean {
    return this.isBefore(LocalDate.now())
}

fun LocalDate.toMonth(): String {
    return this.format(DateTimeFormatter.ofPattern("MMMM"))
}

fun LocalDate.getDateTimeAsString(outputPattern: String = "yyyy-MM-dd HH:mm"): String {
    val simpleDateFormat = DateTimeFormatter.ofPattern(outputPattern)
    return simpleDateFormat.format(this)
}

fun LocalDate.getDateAsString(outputPattern: String = "yyyy-MM-dd"): String {
    val simpleDateFormat = DateTimeFormatter.ofPattern(outputPattern)
    return simpleDateFormat.format(this)
}

fun LocalDate.getTimeAsString(outputPattern: String = "HH:mm"): String {
    val simpleDateFormat = DateTimeFormatter.ofPattern(outputPattern)
    return simpleDateFormat.format(this)
}

fun String.toLocalDate(inputPattern: String = DEFAULT_INPUT_TIME_FORMATTER): LocalDate {
    val parser = DateTimeFormatter.ofPattern(inputPattern)
    return LocalDate.from(parser.parse(this))
}

fun String.parseAndFormat(
    inputPattern: String = DEFAULT_INPUT_TIME_FORMATTER,
    outputPattern: String = "yy-MM-dd"
): String {
    val parser = DateTimeFormatter.ofPattern(inputPattern)
    val formatter = DateTimeFormatter.ofPattern(outputPattern)
    return LocalDate.from(parser.parse(this)).format(formatter)
}

fun String.toLocalDateTime(
    inputPattern: String = DEFAULT_INPUT_TIME_FORMATTER
): LocalDateTime {
    val parser = DateTimeFormatter.ofPattern(inputPattern)
    return LocalDateTime.from(parser.parse(this))
}

fun String.toZonedDateTime(
    inputPattern: String = DEFAULT_INPUT_TIME_FORMATTER,
    zoneId: ZoneId = ZoneId.of("UTC")
): ZonedDateTime {
    val localDateTime = LocalDateTime.parse(
        this,
        DateTimeFormatter.ofPattern(inputPattern)
    )
    return ZonedDateTime.of(
        localDateTime,
        zoneId
    )
}