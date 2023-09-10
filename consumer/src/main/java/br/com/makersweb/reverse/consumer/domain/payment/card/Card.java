package br.com.makersweb.reverse.consumer.domain.payment.card;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

/**
 * @author aaristides
 */
public class Card extends AggregateRoot<CardID> {

    private String cardNumber;
    private String holder;
    private String brand;
    private String expirationDate;
    private String securityCode;
    private String cardToken;
    private Integer installments;
    private boolean saveCard;

    private Card(
            final CardID anId,
            final String aCardNumber,
            final String aHolder,
            final String aBrand,
            final String aExpirationDate,
            final String aSecurityCode,
            final String aCardToken,
            final Integer aInstallments,
            final boolean isSaveCard
    ) {
        super(anId);
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
        final var anId = CardID.unique();
        return new Card(
                anId,
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

    @Override
    public void validate(final ValidationHandler handler) {

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
