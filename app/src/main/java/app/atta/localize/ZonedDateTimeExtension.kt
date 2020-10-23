package app.atta.localize

import org.threeten.bp.DateTimeException
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter


/**
 * Returns a formatted date-time with a different time-zone,
 * retaining the instant.
 * @param dateTimeFormatter  the time-zone to change to, not null
 * @param zoneId  the zone id  you want to get
 * @return a {@code ZonedDateTime} based on this date-time with the requested zone, not null
 * @throws DateTimeException if the result exceeds the supported date range
 */
@Throws(DateTimeException::class)
fun ZonedDateTime.formatWithZone(
    dateTimeFormatter: DateTimeFormatter,
    zoneId: ZoneId = ZoneId.systemDefault()
): String = this.withZoneSameInstant(zoneId).format(dateTimeFormatter)
