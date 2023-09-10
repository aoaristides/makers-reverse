package br.com.makersweb.reverse.consumer.infrastructure.customer.persistence;

import br.com.makersweb.reverse.consumer.domain.customer.CustomerID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author aaristides
 */
@Entity(name = "Customer")
@Table(name = "customer")
public class CustomerJpaEntity {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    public CustomerJpaEntity() {}

    private CustomerJpaEntity(final CustomerID aCustomerId) {
        this.id = aCustomerId.getValue();
    }

    public static CustomerJpaEntity from(final CustomerID aCustomerId) {
        return new CustomerJpaEntity(aCustomerId);
    }

    public String getId() {
        return id;
    }

    public CustomerJpaEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerJpaEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public CustomerJpaEntity setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerJpaEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public CustomerJpaEntity setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public CustomerJpaEntity setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }
}
