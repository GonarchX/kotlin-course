import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class LeftAlign_Test(val inputString: String, val lineWidth: Int, val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf("a", 5, "a"),                    // 0 test:  (inputString = "a", lineWidth = 5, expected = "a")
                arrayOf("a a", 5, "a a"),                // 1 test:  (inputString = "a a", lineWidth = 5, expected = "a a")
                arrayOf("a a a", 5, "a a a"),            // 2 test
                arrayOf("a a a a", 5, "a a a\na"),       // 3 test
                arrayOf("a a a a a", 5, "a a a\na a"),   // 4 test
                arrayOf("abc abc abc", 5,
                            "abc\n" +
                            "abc\n" +
                            "abc"),
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 5,
                    "abc_a\n" +
                            "bc_ab\n" +
                            "c_abc\n" +
                            "!@#\$%\n" +
                            "^&*()\n" +
                            "_"),                        // 5 test
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 100,
                        "abc_abc_abc_abc!@#\$%^&*()_"),  // 6 test
                arrayOf("", 100, ""),                    // 7 test
                arrayOf(" ", 100, "")                    // 8 test
            )
        }
    }

    @Test
    fun leftAlign_RunAllCases() {
        assertEquals(alignText(inputString, Alignment.LEFT, lineWidth), expected)
    }

    @Test(expected = IllegalArgumentException::class)
    fun leftAlign_Exception_zeroLineWidth(){
        alignText("",Alignment.LEFT, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun leftAlign_Exception_negativeLineWidth(){
        alignText("",Alignment.LEFT, -1)
    }
}

@RunWith(Parameterized::class)
class RightAlign_Test(val inputString: String, val lineWidth: Int, val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf("a", 5, "    a"),                     // 0 test:  (inputString = "a", lineWidth = 5, expected = "    a")
                arrayOf("a a", 5, "  a a"),                   // 1 test:
                arrayOf("a a a", 5, "a a a"),                 // 2 test
                 arrayOf("a a a a", 5, "a a a\n    a"),       // 3 test
                 arrayOf("a a a a a", 5, "a a a\n  a a"),     // 4 test
                 arrayOf("abc abc abc", 5,
                     "  abc\n" +
                             "  abc\n" +
                             "  abc"),
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 5,
                    "abc_a\n" +
                            "bc_ab\n" +
                            "c_abc\n" +
                            "!@#\$%\n" +
                            "^&*()\n" +
                            "    _"),                        // 5 test
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 30,
                    "    abc_abc_abc_abc!@#\$%^&*()_"),      // 6 test
                arrayOf("", 5, ""),                    // 7 test
            )
        }
    }

    @Test
    fun rightAlign_RunAllCases() {
        assertEquals(alignText(inputString, Alignment.RIGHT, lineWidth), expected)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rightAlign_Exception_zeroLineWidth(){
        alignText("",Alignment.RIGHT, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rightAlign_Exception_negativeLineWidth(){
        alignText("",Alignment.RIGHT, -1)
    }
}

@RunWith(Parameterized::class)
class CenterAlign_Test(val inputString: String, val lineWidth: Int, val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf("a", 5, "  a"),                    // 0 test:  (inputString = "a", lineWidth = 5, expected = "  a")
                arrayOf("a a", 5, " a a"),                 // 1 test:
                arrayOf("a a a", 5, "a a a"),              // 2 test
                arrayOf("a a a a", 5, "a a a\n  a"),       // 3 test
                arrayOf("a a a a a", 5, "a a a\n a a"),    // 4 test
                arrayOf("abc abc abc", 5,
                    " abc\n" +
                            " abc\n" +
                            " abc"),
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 5,
                    "abc_a\n" +
                            "bc_ab\n" +
                            "c_abc\n" +
                            "!@#\$%\n" +
                            "^&*()\n" +
                            "  _"),                        // 5 test
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 30,
                    "  abc_abc_abc_abc!@#\$%^&*()_"),      // 6 test
                arrayOf("", 5, ""),                        // 7 test
            )
        }
    }

    @Test
    fun centerAlign_RunAllCases() {
        assertEquals(alignText(inputString, Alignment.CENTER, lineWidth), expected)
    }

    @Test(expected = IllegalArgumentException::class)
    fun centerAlign_Exception_zeroLineWidth(){
        alignText("",Alignment.CENTER, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun centerAlign_Exception_negativeLineWidth(){
        alignText("",Alignment.CENTER, -1)
    }
}

@RunWith(Parameterized::class)
class JustifyAlign_Test(val inputString: String, val lineWidth: Int, val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf("a", 5, "a"),                              // 0 test:  (inputString = "a", lineWidth = 5, expected = "a")
                arrayOf("a a", 5, "a   a"),                        // 1 test:
                arrayOf("a a a", 10, "a   a   a"),                 // 2 test
                arrayOf("a  a  a  a", 10, "a  a  a  a"),           // 3 test
                arrayOf("a a a a aaa", 10, "a  a  a  a\naaa"),     // 4 test
                arrayOf("abc abc abc", 5,
                    "abc\n" +
                            "abc\n" +
                            "abc"),
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 5,
                    "abc_a\n" +
                            "bc_ab\n" +
                            "c_abc\n" +
                            "!@#\$%\n" +
                            "^&*()\n" +
                            "_"),                                 // 5 test
                arrayOf("abc_abc_abc_abc!@#$%^&*()_", 30,
                    "abc_abc_abc_abc!@#\$%^&*()_"),               // 6 test
                arrayOf("", 5, ""),                               // 7 test
                arrayOf("abab a aba", 11, "abab a aba"),          // 8 test
            )
        }
    }

    @Test
    fun justifyAlign_RunAllCases() {
        assertEquals(alignText(inputString, Alignment.JUSTIFY, lineWidth), expected)
    }

    @Test(expected = IllegalArgumentException::class)
    fun justifyAlign_Exception_zeroLineWidth(){
        alignText("",Alignment.JUSTIFY, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun justifyAlign_Exception_negativeLineWidth(){
        alignText("",Alignment.JUSTIFY, -1)
    }
}