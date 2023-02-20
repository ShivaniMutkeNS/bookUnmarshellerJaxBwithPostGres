package bookUnmarsheller.bookUnmarsheller.viewModel

import bookUnmarsheller.bookUnmarsheller.model.Book
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
data class CatalogDto(
    var id: String ?=null,

    @field:XmlElement(name = "book")
    val bookDtoList: MutableList<BookDto> = mutableListOf()
)
