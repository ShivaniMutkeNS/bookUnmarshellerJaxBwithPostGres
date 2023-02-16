package bookUnmarsheller.bookUnmarsheller.repository

import bookUnmarsheller.bookUnmarsheller.entity.BookEntity
import bookUnmarsheller.bookUnmarsheller.entity.CatalogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CatalogRepository : JpaRepository<CatalogEntity, Long>{
    fun saveAll(bookEntity: List<BookEntity>):List<BookEntity>
}
