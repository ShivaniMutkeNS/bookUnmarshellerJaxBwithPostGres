package bookUnmarsheller.bookUnmarsheller.repository

import bookUnmarsheller.bookUnmarsheller.model.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface bookRepository : CrudRepository<Book, Long>


