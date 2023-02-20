package bookUnmarsheller.bookUnmarsheller.controller

import bookUnmarsheller.bookUnmarsheller.service.CatalogService
import bookUnmarsheller.bookUnmarsheller.viewModel.BookDto
import bookUnmarsheller.bookUnmarsheller.viewModel.CatalogDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    val catalogService: CatalogService,
) {
    @PostMapping("/catalog")
    fun addCatalog(): CatalogDto {
        return catalogService.unmarshalCatalogFromXmlFile("book.xml")
    }

    @PostMapping("/save")
    fun saveBooks() {
        val catalogDto: CatalogDto = addCatalog()
        val books: MutableList<BookDto> = catalogDto.bookDtoList
        catalogService.saveAll(books)
    }

}