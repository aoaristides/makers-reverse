package br.com.makersweb.reverse.consumer.application.payment.create;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author aaristides
 * @param type
 * @param amount
 * @param card
 * @param billet
 * @param pix
 */
public record CreatePaymentCommand(
        String type,
        BigDecimal amount,
        Card card,
        Billet billet,
        Pix pix
) {

    public static CreatePaymentCommand with(
            final String aType,
            final BigDecimal aAmount,
            final Card aCard,
            final Billet aBillet,
            final Pix aPix
    ) {
        return new CreatePaymentCommand(aType, aAmount, aCard, aBillet, aPix);
    }

}

/**
 * @author aaristides
 * @param cardNumber
 * @param holder
 * @param brand
 * @param expirationDate
 * @param securityCode
 * @param cardToken
 * @param installments
 * @param isSaveCard
 */
record Card(
        String cardNumber,
        String holder,
        String brand,
        String expirationDate,
        String securityCode,
        String cardToken,
        Integer installments,
        boolean isSaveCard
) {

    public static Card with(
            final String aCardNumber,
            final String aHolder,
            final String aBrand,
            final String aExpirationDate,
            final String aSecurityCode,
            final String aCardToken,
            final Integer aInstallments,
            final boolean isSaveCard
    ) {
        return new Card(aCardNumber, aHolder, aBrand, aExpirationDate, aSecurityCode, aCardToken, aInstallments, isSaveCard);
    }

}

/**
 * @author aaristides
 * @param expirationDate
 * @param daysToExpire
 * @param link
 * @param barCode
 * @param account
 */
record Billet(
        LocalDate expirationDate,
        Integer daysToExpire,
        String link,
        String barCode,
        Account account
) {

    public static Billet with(
            final LocalDate aExpirationDate,
            final Integer aDaysToExpire,
            final String aLink,
            final String aBarCode,
            final Account aAccount
    ) {
        return new Billet(aExpirationDate, aDaysToExpire, aLink, aBarCode, aAccount);
    }

}

/**
 * @author aaristides
 * @param name
 * @param type
 * @param agency
 * @param accountNumber
 * @param bankNumber
 * @param document
 */
record Account(
        String name,
        String type,
        String agency,
        String accountNumber,
        String bankNumber,
        String document
) {

    public static Account with(
            final String aName,
            final String aType,
            final String aAgency,
            final String aAccountNumber,
            final String aBankNumber,
            final String aDocument
    ) {
        return new Account(aName, aType, aAgency, aAccountNumber, aBankNumber, aDocument);
    }

}

/**
 * @author aaristides
 * @param pspReferenceId
 * @param referenceId
 * @param message
 */
record Pix(
        String pspReferenceId,
        String referenceId,
        String message
) {

    public static Pix with(
            final String aPspReferenceId,
            final String aReferenceId,
            final String aMessage
    ) {
        return new Pix(aPspReferenceId, aReferenceId, aMessage);
    }

}