package bookUnmarsheller.bookUnmarsheller.entity

import javax.persistence.*
@Entity
@Table(name = "catalog")
data class Catalog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToMany()
    @JoinColumn(name = "catalog_id")
    val books: List<Book> = emptyList()
)
