package bookUnmarsheller.bookUnmarsheller.controller

import bookUnmarsheller.bookUnmarsheller.jaxbmarshellar.*
import bookUnmarsheller.bookUnmarsheller.service.CatalogService
import bookUnmarsheller.bookUnmarsheller.viewModel.BookDto
import bookUnmarsheller.bookUnmarsheller.viewModel.CatalogDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    val catalogService: CatalogService,
) {
    @PostMapping("/catalog")
    fun addCatalog(): CatalogDto {
        return catalogService.unmarshalCatalogFromXmlFile("book.xml")
    }

    @PostMapping("/save")
    fun saveBooks() {
        val catalogDto: CatalogDto = addCatalog()
        val books: MutableList<BookDto> = catalogDto.bookDtoList
        catalogService.saveAll(books)
    }

    @PostMapping("/getVouchers")
    fun getVouchersOrder() {
        val order = Order("productorder", 2, 23, "delivery address", "distribution address", "invoiceaddress")
        val address = Address("streetname", "housenumber", "zipcode", "city", "country")
        val beneficiary =
            Beneficiary("benificialid1", "actioncode", "lastname", "firsname", "language", address = address, order)
        val contact = Contact("conct1", "contactname", "languagename", "emailname")
        val senderData = SenderData("123r", contact)
        val customerAddress = CustomerAddress("address id", "location name", address)
        val customerOrder = CustomerOrder("123r", "pune", "orderRef", contact, beneficiary, customerAddress)
        val vouchersOrder = VouchersOrder(senderData, customerOrder)
        catalogService.marshaller(vouchersOrder)
    }

}

