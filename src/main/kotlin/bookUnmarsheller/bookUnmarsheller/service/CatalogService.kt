package bookUnmarsheller.bookUnmarsheller.service
import bookUnmarsheller.bookUnmarsheller.BookDto
import bookUnmarsheller.bookUnmarsheller.BookDataClass
import bookUnmarsheller.bookUnmarsheller.entity.BookEntity
import bookUnmarsheller.bookUnmarsheller.repository.CatalogRepository
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import javax.xml.bind.JAXBContext

@Service
class CatalogService(private val catalogRepository: CatalogRepository) {
    fun saveAllBooks(xmlFilePath: String) {
        val catalogDto = unmarshalCatalogFromXmlFile(xmlFilePath)
        val bookEntities = catalogDto.books.map { toBookEntity(it)}
        catalogRepository.saveAll(bookEntities)
    }

    fun unmarshalCatalogFromXmlFile(filePath: String): BookDataClass {
        val file = ClassPathResource(filePath)
        val jaxbContext = JAXBContext.newInstance(BookDataClass::class.java)
        val unmarshaller = jaxbContext.createUnmarshaller()
        return unmarshaller.unmarshal(file.inputStream) as BookDataClass
    }

    fun toBookEntity(bookDto: BookDto):BookEntity{
        return BookEntity(
            id = bookDto.id?.toLong(),
            author = bookDto.author.orEmpty(),
            title=bookDto.title.toString(),
            genre=bookDto.genre.toString(),
            price=bookDto.price,
            publishDate = bookDto.publish_date,
            description = bookDto.description.toString()

        )
    }
}



