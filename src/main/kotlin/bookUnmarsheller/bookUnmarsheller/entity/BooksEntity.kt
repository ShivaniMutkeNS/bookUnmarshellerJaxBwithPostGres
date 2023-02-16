package bookUnmarsheller.bookUnmarsheller.entity

import javax.persistence.*

@Entity
@Table(name = "book")
data class BookEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name="author")
    val author: String,

    @Column(name="title")
    val title: String,

    @Column(name="genre")
    val genre: String,

    @Column(name="price")
    val price: Double,

    @Column(name = "publishDate")
    val publishDate: String?,

    @Column(name="description")
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id")
    var catalog: CatalogEntity? = null
)
