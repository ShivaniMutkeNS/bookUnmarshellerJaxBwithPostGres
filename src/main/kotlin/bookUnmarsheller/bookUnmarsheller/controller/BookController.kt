package bookUnmarsheller.bookUnmarsheller.controller

import bookUnmarsheller.bookUnmarsheller.BookDataClass
import bookUnmarsheller.bookUnmarsheller.BookDto
import bookUnmarsheller.bookUnmarsheller.service.CatalogService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class BookController (
    private val catalogService: CatalogService,
){
    @PostMapping("/catalog", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addCatalog(): ResponseEntity<BookDataClass> {
        val book = catalogService.unmarshalCatalogFromXmlFile("book.xml")
        return ResponseEntity.ok(book)
    }
    @PostMapping("/save")
    fun saveBooks(@RequestBody bookDtos: List<BookDto>): ResponseEntity<String> {
        try {
            catalogService.saveAllBooks("book.xml")
            return ResponseEntity.ok("Books saved successfully")
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save books")
        }
    }

}