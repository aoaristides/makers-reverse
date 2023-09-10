package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.payment;

import br.com.makersweb.reverse.consumer.domain.payment.*;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.BilletJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.card.CardJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.pix.PixJpaEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author aaristides
 */
@Entity(name = "Payment")
@Table(name = "payment")
public class PaymentJpaEntity {

    @Id
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardJpaEntity card;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billet_id")
    private BilletJpaEntity billet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pix_id")
    private PixJpaEntity pix;

    public PaymentJpaEntity() {}

    private PaymentJpaEntity(final PaymentID aPaymentId) {
        this.id = aPaymentId.getValue();
    }

    public static PaymentJpaEntity from(final PaymentID aPaymentId) {
        return new PaymentJpaEntity(aPaymentId);
    }

    public String getId() {
        return id;
    }

    public PaymentJpaEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CardJpaEntity getCard() {
        return card;
    }

    public void setCard(CardJpaEntity card) {
        this.card = card;
    }

    public BilletJpaEntity getBillet() {
        return billet;
    }

    public void setBillet(BilletJpaEntity billet) {
        this.billet = billet;
    }

    public PixJpaEntity getPix() {
        return pix;
    }

    public void setPix(PixJpaEntity pix) {
        this.pix = pix;
    }
}
