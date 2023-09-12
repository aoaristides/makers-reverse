package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.account;

import br.com.makersweb.reverse.consumer.domain.payment.billet.account.Account;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author aaristides
 */
@Entity(name = "Account")
@Table(name = "account")
public class AccountJpaEntity {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "agency")
    private String agency;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "bank_number")
    private String bankNumber;

    @Column(name = "document")
    private String document;

    public AccountJpaEntity() {}

    private AccountJpaEntity(
            final String id,
            final String name,
            final String type,
            final String agency,
            final String accountNumber,
            final String bankNumber,
            final String document
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.bankNumber = bankNumber;
        this.document = document;
    }

    private AccountJpaEntity(final AccountID anId) {
        this.id = anId.getValue();
    }

    public static AccountJpaEntity from(final AccountID anId) {
        return new AccountJpaEntity(anId);
    }

    public static AccountJpaEntity from(final Account aAccount) {
        return new AccountJpaEntity(
                aAccount.getId().getValue(),
                aAccount.getName(),
                aAccount.getType(),
                aAccount.getAgency(),
                aAccount.getAccountNumber(),
                aAccount.getBankNumber(),
                aAccount.getDocument()
        );
    }

    public Account toAggregate() {
        return Account.with(
                AccountID.from(getId()),
                getName(),
                getType(),
                getAgency(),
                getAccountNumber(),
                getBankNumber(),
                getDocument()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
