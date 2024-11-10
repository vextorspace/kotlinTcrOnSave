import com.ronnev.main
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest :
        ExpectSpec({
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

            context("Called with Bob and Jen as arguments") {
                expect("should print Hello Bob and Jen!") {
                    val outputStream = ByteArrayOutputStream()
                    val printStream = PrintStream(outputStream)

                    System.setOut(printStream)
                    main(arrayOf("Bob", "Jen"))
                    outputStream.toString() shouldBe "Hello Bob and Jen!\n"
                }
            }

            context("Called with Joel, Jerome, and Mathew") {
                expect("should print Hello my Brothers!") {
                    val outputStream = ByteArrayOutputStream()
                    val printStream = PrintStream(outputStream)

                    System.setOut(printStream)
                    main(arrayOf("Joel", "Jerome", "Joel"))
                    outputStream.toString() shouldBe "Hello my Brothers!\n"
                }
            }
        })
