package bookUnmarsheller.bookUnmarsheller

import bookUnmarsheller.bookUnmarsheller.model.Book
import java.util.*
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
data class BookDataClass(

    var id: String ?=null,

    @field:XmlElement(name = "book")
    val books: List<BookDto> = emptyList()
)
@XmlAccessorType(XmlAccessType.FIELD)
data class BookDto(

    @field:XmlElement(name = "id")
    var id: String ?=null,

    @field:XmlElement(name = "author")
    var author: String ?=null,

    @field:XmlElement(name = "title")
    var title: String ?=null,

    @field:XmlElement(name = "genre")
    var genre: String?=null,

    @field:XmlElement(name = "price")
    var price: Double ,

    @field:XmlElement(name = "publish_date")
    var publish_date:String ?= null,

    @field:XmlElement(name = "description")
    var description:String ?= null,

){
    fun toBookEntity(bookDto: BookDto): Book {
        return Book(
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