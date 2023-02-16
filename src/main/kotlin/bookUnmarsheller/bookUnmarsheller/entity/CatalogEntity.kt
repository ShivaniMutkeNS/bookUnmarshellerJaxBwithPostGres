package bookUnmarsheller.bookUnmarsheller.entity

import javax.persistence.*

@Entity
@Table(name = "catalog")
data class CatalogEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "catalog_id")
    val books: MutableList<BookEntity> = mutableListOf()
)