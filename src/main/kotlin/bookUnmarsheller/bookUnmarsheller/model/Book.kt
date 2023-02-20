package bookUnmarsheller.bookUnmarsheller.model

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Column(name = "author")
    val author: String,

    @Column(name = "title")
    val title: String,

    @Column(name = "genre")
    val genre: String,

    @Column(name = "price")
    val price: Double,

    @Column(name = "publishDate")
    val publishDate: String,

    @Column(name = "description")
    val description: String,


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

}
