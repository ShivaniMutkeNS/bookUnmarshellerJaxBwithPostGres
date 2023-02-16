
import bookUnmarsheller.bookUnmarsheller.BookDataClass
import org.springframework.stereotype.Component

@Component
class BookDataHolder {

    var myData: BookDataClass? = null
    fun printData() {
        println(myData)
    }

}