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
            outputStream.toString() shouldBe "Hello World!\n"
        }
    }

    context("Called with Bob as Argument") {
        expect("should print Hello Bob!") {
            val outputStream = ByteArrayOutputStream()
            val printStream = PrintStream(outputStream)

            System.setOut(printStream)
            main(arrayOf("Bob"))
            outputStream.toString() shouldBe "Hello Bob!\n"
        }
    }
})
