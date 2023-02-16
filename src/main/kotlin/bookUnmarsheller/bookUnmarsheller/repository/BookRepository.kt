package bookUnmarsheller.bookUnmarsheller.repository

import bookUnmarsheller.bookUnmarsheller.model.Book
import bookUnmarsheller.bookUnmarsheller.model.Catalog
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface bookRepository : CrudRepository<Catalog, Long>


