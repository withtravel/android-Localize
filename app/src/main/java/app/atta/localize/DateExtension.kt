package app.atta.localize

import java.text.SimpleDateFormat
import java.util.*


fun Date.getDateTimeAsString(pattern: String = "yyyy-MM-dd HH:mm"): String {
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return simpleDateFormat.format(this)
}

fun Date.getDateAsString(pattern: String = "yyyy-MM-dd"): String {
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return simpleDateFormat.format(this)
}

fun Date.getTimeAsString(pattern: String = "HH:mm"): String {
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return simpleDateFormat.format(this)
}
