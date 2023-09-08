package br.com.makersweb.reverse.consumer.domain.customer;

import br.com.makersweb.reverse.consumer.domain.ValueObject;

import java.time.LocalDate;

/**
 * @author aaristides
 */
public class Customer extends ValueObject {

    private String name;
    private String document;
    private String phone;
    private String mail;
    private LocalDate birthDay;

    private Customer(
            final String aName,
            final String aDocument,
            final String aPhone,
            final String aMail,
            final LocalDate aBirthDay
    ) {
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
        return new Customer(aName, aDocument, aPhone, aMail, aBirthDay);
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
