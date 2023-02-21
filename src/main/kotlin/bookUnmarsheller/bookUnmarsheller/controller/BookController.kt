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

        val vouchersOrder = VouchersOrder().apply {
            senderData = SenderData().apply {
                companyId = "12345678"
                contact = Contact().apply {
                    name = "Christelle Rigaux"
                    language = "FR"
                    email = "christelle.rigaux@expertmed.be"
                }
            }
            customerOrder = CustomerOrder().apply {
                companyId = "0652607684"
                companyAddress = "00001"
                beneficiary = Beneficiary().apply {
                    beneficiaryId = "INSS-81101924088"
                    actionCode = "1"
                    name = "Rigaux"
                    firstName = "Christelle"
                    language = "FR"
                    address = Address().apply {
                        street = "Avenue Emile Van Becelaere, 52"
                        zipCode = "1170"
                        city = "WATERMAEL-BOITSFORT"
                        country = "BE"
                    }
                    order = Order().apply {
                        product = "MVE"
                        quantity = 55
                        value = 800
                        deliveryAddress = "00001"
                    }
                }
                customerAddress = CustomerAddress().apply {
                    addressId = "00001"
                }
            }
        }
        catalogService.marshaller(vouchersOrder)
    }

}

/*
        val order = Order("productorder", 2, 23, "delivery address", "distribution address", "invoiceaddress")
        val address = Address("streetname", "housenumber", "zipcode", "city", "country")
        val beneficiary =
            Beneficiary("benificialid1", "actioncode", "lastname", "firsname", "language", address = address, order)
        val contact = Contact("conct1", "contactname", "languagename", "emailname")
        val senderData = SenderData("123r", contact)
        val customerAddress = CustomerAddress("address id", "location name", address)
        val customerOrder = CustomerOrder("123r", "pune", "orderRef", contact, beneficiary, customerAddress)
        val vouchersOrder = VouchersOrder(senderData, customerOrder)
*/

