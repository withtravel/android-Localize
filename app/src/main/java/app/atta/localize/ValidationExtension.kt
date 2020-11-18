package app.atta.localize

import androidx.core.util.PatternsCompat
import java.util.*

fun String.isValidEmail(): Boolean {
    return PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPhoneNumber(local: Locale): Boolean {
    val replaced = this.trim().replace("-", "")
    return replaced.matches(Regex(getPhoneNumberPattern(local)))
}

// for now we support japan only
fun String.isValidPostalCode(local: Locale = Locale.JAPAN): Boolean {
    return this.trim().matches(Regex(getPostalPattern(local)))
}

// for now we support japan only
fun getPhoneNumberPattern(local: Locale = Locale.JAPAN): String {
    return when (local) {
        Locale.JAPAN, Locale.JAPANESE -> {
            "(\\+[0-9]+[\\- \\.]*)?[0-9]{10,13}\$"
        }
        else -> {
            ""
        }
    }

}

fun getPostalPattern(local: Locale): String {
    return when (local) {
        Locale.JAPAN, Locale.JAPANESE -> {
            "\\d{3}-\\d{4}"
        }
        else -> {
            ""
        }
    }
}
