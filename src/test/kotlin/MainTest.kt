import com.ronnev.main
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest : ExpectSpec({

    context("Main") {
        expect("should print Hello World!") {
            val outputStream = ByteArrayOutputStream()
            val printStream = PrintStream(outputStream)

            System.setOut(printStream)
            main()
            outputStream shouldBe "Hello World!"
        }
    }
})
