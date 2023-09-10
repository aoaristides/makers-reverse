package br.com.makersweb.reverse.consumer.domain.customer;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

import java.time.LocalDate;

/**
 * @author aaristides
 */
public class Customer extends AggregateRoot<CustomerID> {

    private String name;
    private String document;
    private String phone;
    private String mail;
    private LocalDate birthDay;

    private Customer(
            final CustomerID anId,
            final String aName,
            final String aDocument,
            final String aPhone,
            final String aMail,
            final LocalDate aBirthDay
    ) {
        super(anId);
        this.name = aName;
        this.document = aDocument;
        this.phone = aPhone;
        this.mail = aMail;
        this.birthDay = aBirthDay;
    }

    public static Customer newCustomer(
            final String aName,
            final String aDocument,
            final String aPhone,
            final String aMail,
            final LocalDate aBirthDay
    ) {
        final var anId = CustomerID.unique();
        return new Customer(anId, aName, aDocument, aPhone, aMail, aBirthDay);
    }

    public static Customer with(
            final CustomerID anId,
            final String aName,
            final String aDocument,
            final String aPhone,
            final String aMail,
            final LocalDate aBirthDay
    ) {
        return new Customer(anId, aName, aDocument, aPhone, aMail, aBirthDay);
    }

    public static Customer with(final Customer customer) {
        return with(
                customer.getId(),
                customer.name,
                customer.document,
                customer.phone,
                customer.mail,
                customer.birthDay
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {

    }

    public CustomerID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }
}
