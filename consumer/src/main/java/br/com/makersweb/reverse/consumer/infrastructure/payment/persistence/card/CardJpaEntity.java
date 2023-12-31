package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.card;

import br.com.makersweb.reverse.consumer.domain.payment.card.Card;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author aaristides
 */
@Entity(name = "Card")
@Table(name = "card")
public class CardJpaEntity {

    @Id
    private String id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "holder")
    private String holder;

    @Column(name = "brand")
    private String brand;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "security_code")
    private String securityCode;

    @Column(name = "card_token")
    private String cardToken;

    @Column(name = "installments")
    private Integer installments;

    @Column(name = "save_card")
    private boolean saveCard;

    public CardJpaEntity() {
    }

    private CardJpaEntity(
            final String id,
            final String cardNumber,
            final String holder,
            final String brand,
            final String expirationDate,
            final String securityCode,
            final String cardToken,
            final Integer installments,
            final boolean saveCard
    ) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.holder = holder;
        this.brand = brand;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.cardToken = cardToken;
        this.installments = installments;
        this.saveCard = saveCard;
    }

    private CardJpaEntity(final CardID aCardId) {
        this.id = aCardId.getValue();
    }

    public static CardJpaEntity from(final CardID aCardId) {
        return new CardJpaEntity(aCardId);
    }

    public static CardJpaEntity from(final Card aCard) {
        return new CardJpaEntity(
                aCard.getId().getValue(),
                aCard.getCardNumber(),
                aCard.getHolder(),
                aCard.getBrand(),
                aCard.getExpirationDate(),
                aCard.getSecurityCode(),
                aCard.getCardToken(),
                aCard.getInstallments(),
                aCard.isSaveCard()
        );
    }

    public Card toAggregate() {
        return Card.with(
                CardID.from(getId()),
                getCardNumber(),
                getHolder(),
                getBrand(),
                getExpirationDate(),
                getSecurityCode(),
                getCardToken(),
                getInstallments(),
                isSaveCard()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public boolean isSaveCard() {
        return saveCard;
    }

    public void setSaveCard(boolean saveCard) {
        this.saveCard = saveCard;
    }
}
