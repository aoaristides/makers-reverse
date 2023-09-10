package br.com.makersweb.reverse.consumer.domain.payment.billet.account;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

/**
 * @author aaristides
 */
public class Account extends AggregateRoot<AccountID> {

    private String name;
    private String type;
    private String agency;
    private String accountNumber;
    private String bankNumber;
    private String document;

    private Account(
            final AccountID anId,
            final String aName,
            final String aType,
            final String aAgency,
            final String aAccountNumber,
            final String aBankNumber,
            final String aDocument
    ) {
        super(anId);
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
        final var anId = AccountID.unique();
        return new Account(anId, aName, aType, aAgency, aAccountNumber, aBankNumber, aDocument);
    }

    public static Account with(
            final AccountID anId,
            final String aName,
            final String aType,
            final String aAgency,
            final String aAccountNumber,
            final String aBankNumber,
            final String aDocument
    ) {
        return new Account(anId, aName, aType, aAgency, aAccountNumber, aBankNumber, aDocument);
    }

    public static Account with(final Account aAccount) {
        return with(
                aAccount.getId(),
                aAccount.name,
                aAccount.type,
                aAccount.agency,
                aAccount.accountNumber,
                aAccount.bankNumber,
                aAccount.document
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {

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
