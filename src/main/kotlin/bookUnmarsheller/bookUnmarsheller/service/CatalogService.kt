package bookUnmarsheller.bookUnmarsheller.service

import bookUnmarsheller.bookUnmarsheller.jaxbmarshellar.VouchersOrder
import bookUnmarsheller.bookUnmarsheller.model.Book
import bookUnmarsheller.bookUnmarsheller.repository.bookRepository
import bookUnmarsheller.bookUnmarsheller.viewModel.BookDto
import bookUnmarsheller.bookUnmarsheller.viewModel.CatalogDto
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

@Service
class CatalogService(val bookRepository: bookRepository) {
    fun unmarshalCatalogFromXmlFile(filePath: String): CatalogDto {
        val file = ClassPathResource(filePath)
        val jaxbContext = JAXBContext.newInstance(CatalogDto::class.java)
        val unmarshaller = jaxbContext.createUnmarshaller()
        val mydata: CatalogDto = unmarshaller.unmarshal(file.inputStream) as CatalogDto
        println(mydata)

        return mydata
    }

    fun saveAll(books: List<BookDto>) {
        for (book in books) {
            val bookEntity = toBookEntity(book)
            bookRepository.save(bookEntity)
        }
    }

    fun toBookEntity(bookDto: BookDto): Book {

        return Book(
            author = bookDto.author,
            title = bookDto.title,
            genre = bookDto.genre,
            price = bookDto.price,
            publishDate = bookDto.publishDate,
            description = bookDto.description
            //bookDto.author,bookDto.title,bookDto.genre,bookDto.price,bookDto.publish_date,bookDto.description
        )
    }

    fun marshaller(vouchersOrder: VouchersOrder) {
        val jaxbContext = JAXBContext.newInstance(VouchersOrder::class.java)
        val marshaller = jaxbContext.createMarshaller()
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        val outputFile = File("src/main/resources/voucherOrder.xml")
        marshaller.marshal(vouchersOrder, outputFile)
    }
}



