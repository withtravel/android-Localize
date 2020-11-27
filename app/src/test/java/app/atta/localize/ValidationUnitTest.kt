package app.atta.localize

import org.junit.Test

import org.junit.Assert.*
import java.util.*


class ValidationUnitTest {

    @Test
    fun `validate postal code in japan`() {
        val input1 = "123-0001"
        val input2 = "12-0001"
        val input3 = "1-0001"
        val input4 = "1230001"
        val input5 = "0001"
        val input6 = "aaaa"
        val locale = Locale.JAPAN
        assertTrue(input1.isValidPostalCode(locale))
        assertFalse(input2.isValidPostalCode(locale))
        assertFalse(input3.isValidPostalCode(locale))
        assertFalse(input4.isValidPostalCode(locale))
        assertFalse(input5.isValidPostalCode(locale))
        assertFalse(input6.isValidPostalCode(locale))
    }

    @Test
    fun `validate phone number in japan`() {
        val input1 = "09000010004"
        val input2 = "090-0001-0002"
        val input3 = "+81 9000010004"
        val input4 = "+81 90-0001-0002"
        val input5 = "0-0001-0002"
        val input6 = "000010002"
        val input7 = "03-0001-0002"
        val input8 = "aaaa"
        val input9 = "08000010004"
        val input10 = "07000010004"
        val input11 = "06000010004"
        val input12 = "080000100040"
        val locale = Locale.JAPAN

        assertTrue(input1.isValidPhoneNumber(locale))
        assertTrue(input2.isValidPhoneNumber(locale))
        assertFalse(input3.isValidPhoneNumber(locale))
        assertFalse(input4.isValidPhoneNumber(locale))
        assertFalse(input5.isValidPhoneNumber(locale))
        assertFalse(input6.isValidPhoneNumber(locale))
        assertFalse(input7.isValidPhoneNumber(locale))
        assertFalse(input8.isValidPhoneNumber(locale))
        assertTrue(input9.isValidPhoneNumber(locale))
        assertTrue(input10.isValidPhoneNumber(locale))
        assertFalse(input11.isValidPhoneNumber(locale))
        assertFalse(input12.isValidPhoneNumber(locale))
    }

    @Test
    fun `validate email address`() {
        val input1 = "atta@atta.ai"
        val input2 = "atta.ai"
        val input3 = "atta.ai"
        val input4 = "atta@yahoo.co.jp"
        val input5 = "atta@gmail.com"
        assertTrue(input1.isValidEmail())
        assertFalse(input2.isValidEmail())
        assertFalse(input3.isValidEmail())
        assertTrue(input4.isValidEmail())
        assertTrue(input5.isValidEmail())
    }
}