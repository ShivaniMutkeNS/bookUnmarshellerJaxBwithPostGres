package bookUnmarsheller.bookUnmarsheller.jaxbmarshellar

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "VouchersOrder")
@XmlAccessorType(XmlAccessType.FIELD)
data class VouchersOrder(
    @XmlElement
    var senderData: SenderData?=null,
    @XmlElement
    var customerOrder: CustomerOrder?=null
)
@XmlAccessorType(XmlAccessType.FIELD)
data class SenderData(
    @XmlElement
    var companyId: String="",
    @XmlElement
    var contact: Contact?=null
)

@XmlAccessorType(XmlAccessType.FIELD)
data class CustomerOrder(
    @XmlElement
    var companyId: String="",
    @XmlElement
    var companyAddress: String="",
    @XmlElement
    var orderReference: String="",
    @XmlElement
    var contact: Contact?=null,
    @XmlElement
    var beneficiary: Beneficiary?=null,
    @XmlElement
    var customerAddress: CustomerAddress?=null
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Contact(
    @XmlElement
    var contactId: String="",
    @XmlElement
    var name: String="",
    @XmlElement
    var language: String="",
    @XmlElement
    var email: String=""
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Beneficiary(
    @XmlElement
    var beneficiaryId: String="",
    @XmlElement
    var actionCode: String="",
    @XmlElement
    var name: String="",
    @XmlElement
    var firstName: String="",
    @XmlElement
    var language: String="",
    @XmlElement
    var address: Address?=null,
    @XmlElement
    var order: Order?=null
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Address(
    @XmlElement
    var street: String="",
    @XmlElement
    var houseNumber: String="",
    @XmlElement
    var zipCode: String="",
    @XmlElement
    var city: String="",
    @XmlElement
    var country: String=""
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Order(
    @XmlElement
    var product: String="",
    @XmlElement
    var quantity: Int=0,
    @XmlElement
    var value: Int=0,
    @XmlElement
    var deliveryAddress: String="",
    @XmlElement
    var distributionAddress: String="",
    @XmlElement
    var invoiceAddress: String=""
)

@XmlAccessorType(XmlAccessType.FIELD)
data class CustomerAddress(
    @XmlElement
    var addressId: String="",
    @XmlElement
    var locationName: String="",
    @XmlElement
    var address: Address?=null
)