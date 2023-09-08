package br.com.makersweb.reverse.consumer.domain.payment;

import br.com.makersweb.reverse.consumer.domain.ValueObject;

/**
 * @author aaristides
 */
public class Card extends ValueObject {

    private String cardNumber;
    private String holder;
    private String brand;
    private String expirationDate;
    private String securityCode;
    private String cardToken;
    private Integer installments;
    private boolean saveCard;

    private Card(
            final String aCardNumber,
            final String aHolder,
            final String aBrand,
            final String aExpirationDate,
            final String aSecurityCode,
            final String aCardToken,
            final Integer aInstallments,
            final boolean isSaveCard
    ) {
        this.cardNumber = aCardNumber;
        this.holder = aHolder;
        this.brand = aBrand;
        this.expirationDate = aExpirationDate;
        this.securityCode = aSecurityCode;
        this.cardToken = aCardToken;
        this.installments = aInstallments;
        this.saveCard = isSaveCard;
    }

    public static Card newCard(
            final String aCardNumber,
            final String aHolder,
            final String aBrand,
            final String aExpirationDate,
            final String aSecurityCode,
            final String aCardToken,
            final Integer aInstallments,
            final boolean isSaveCard
    ) {
        return new Card(
                aCardNumber,
                aHolder,
                aBrand,
                aExpirationDate,
                aSecurityCode,
                aCardToken,
                aInstallments,
                isSaveCard
        );
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getHolder() {
        return holder;
    }

    public String getBrand() {
        return brand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getCardToken() {
        return cardToken;
    }

    public Integer getInstallments() {
        return installments;
    }

    public boolean isSaveCard() {
        return saveCard;
    }
}
