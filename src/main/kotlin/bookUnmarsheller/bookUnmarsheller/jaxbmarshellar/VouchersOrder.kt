package bookUnmarsheller.bookUnmarsheller.jaxbmarshellar

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "VouchersOrder")
@XmlAccessorType(XmlAccessType.FIELD)
data class VouchersOrder(
    @field:XmlElement(name = "SenderData")
    var senderData: SenderData? = null,
    @field:XmlElement(name = "CustomerOrder")
    var customerOrder: CustomerOrder? = null,
)

@XmlAccessorType(XmlAccessType.FIELD)
data class SenderData(
    @field:XmlElement(name = "CompanyId")
    var companyId: String = "",
    @field:XmlElement(name = "Contact")
    var contact: Contact? = null,
)

@XmlAccessorType(XmlAccessType.FIELD)
data class CustomerOrder(
    @field:XmlElement(name = "CompanyID")
    var companyId: String = "",
    @field:XmlElement(name = "CompanyAddress")
    var companyAddress: String = "",
    @field:XmlElement(name = "OrderReference")
    var orderReference: String = "",
    @field:XmlElement(name = "Contact")
    var contact: Contact? = null,
    @field:XmlElement(name = "Beneficiary")
    var beneficiary: Beneficiary? = null,
    @field:XmlElement(name = "CustomerAddress")
    var customerAddress: CustomerAddress? = null,
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Contact(
    @field:XmlElement(name = "ContactId")
    var contactId: String = "",
    @field:XmlElement(name = "Name")
    var name: String = "",
    @field:XmlElement(name = "Language")
    var language: String = "",
    @field:XmlElement(name = "Email")
    var email: String = "",
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Beneficiary(
    @field:XmlElement(name = "BeneficiaryId")
    var beneficiaryId: String = "",
    @field:XmlElement(name = "ActionCode")
    var actionCode: String = "",
    @field:XmlElement(name = "Name")
    var name: String = "",
    @field:XmlElement(name = "FirstName")
    var firstName: String = "",
    @field:XmlElement(name = "Language")
    var language: String = "",
    @field:XmlElement(name = "Address")
    var address: Address? = null,
    @field:XmlElement(name = "Order")
    var order: Order? = null,
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Address(
    @field:XmlElement(name = "Street")
    var street: String = "",
    @field:XmlElement(name = "HouseNumber")
    var houseNumber: String = "",
    @field:XmlElement(name = "ZipCode")
    var zipCode: String = "",
    @field:XmlElement(name = "City")
    var city: String = "",
    @field:XmlElement(name = "Country")
    var country: String = "",
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Order(
    @field:XmlElement(name = "Product")
    var product: String = "",
    @field:XmlElement(name = "Quantity")
    var quantity: Int = 0,
    @field:XmlElement(name = "Value")
    var value: Int = 0,
    @field:XmlElement(name = "DeliveryAddress")
    var deliveryAddress: String = "",
    @field:XmlElement(name = "DistributionAddress")
    var distributionAddress: String = "",
    @field:XmlElement(name = "InvoiceAddress")
    var invoiceAddress: String = "",
)

@XmlAccessorType(XmlAccessType.FIELD)
data class CustomerAddress(
    @field:XmlElement(name = "AddressId")
    var addressId: String = "",
    @field:XmlElement(name = "LocationName")
    var locationName: String = "",
    @field:XmlElement(name = "Address")
    var address: Address? = null,
)