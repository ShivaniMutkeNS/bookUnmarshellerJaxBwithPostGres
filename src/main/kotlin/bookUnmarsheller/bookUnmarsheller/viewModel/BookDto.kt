package bookUnmarsheller.bookUnmarsheller.viewModel

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
class BookDto(
    @field:XmlElement(name = "id")
    var id: String = "",

    @field:XmlElement(name = "author")
    var author: String = "",

    @field:XmlElement(name = "title")
    var title: String = "",

    @field:XmlElement(name = "genre")
    var genre: String = "",

    @field:XmlElement(name = "price")
    var price: Double = 0.0,

    @field:XmlElement(name = "publish_date")
    var publishDate: String = "",

    @field:XmlElement(name = "description")
    var description: String = "",
)