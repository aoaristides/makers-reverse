package br.com.makersweb.reverse.consumer.domain.payment;

import br.com.makersweb.reverse.consumer.domain.ValueObject;

/**
 * @author aaristides
 */
public class Account extends ValueObject {

    private String name;
    private String type;
    private String agency;
    private String accountNumber;
    private String bankNumber;
    private String document;

    private Account(
            final String aName,
            final String aType,
            final String aAgency,
            final String aAccountNumber,
            final String aBankNumber,
            final String aDocument
    ) {
        this.name = aName;
        this.type = aType;
        this.agency = aAgency;
        this.accountNumber = aAccountNumber;
        this.bankNumber = aBankNumber;
        this.document = aDocument;
    }

    public static Account newAccount(
            final String aName,
            final String aType,
            final String aAgency,
            final String aAccountNumber,
            final String aBankNumber,
            final String aDocument
    ) {
        return new Account(aName, aType, aAgency, aAccountNumber, aBankNumber, aDocument);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getDocument() {
        return document;
    }
}
