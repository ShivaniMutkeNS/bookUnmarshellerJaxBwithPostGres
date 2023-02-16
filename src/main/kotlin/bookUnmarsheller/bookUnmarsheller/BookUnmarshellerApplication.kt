package bookUnmarsheller.bookUnmarsheller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookUnmarshellerApplication

fun main(args: Array<String>) {
	runApplication<BookUnmarshellerApplication>(*args)
}
