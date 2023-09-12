package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.payment;

import br.com.makersweb.reverse.consumer.domain.payment.*;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletID;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardID;
import br.com.makersweb.reverse.consumer.domain.payment.pix.PixID;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.BilletJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.card.CardJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.pix.PixJpaEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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

    public PaymentJpaEntity() {
    }

    private PaymentJpaEntity(
            String id,
            String type,
            BigDecimal amount,
            CardJpaEntity card,
            BilletJpaEntity billet,
            PixJpaEntity pix
    ) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.card = card;
        this.billet = billet;
        this.pix = pix;
    }

    private PaymentJpaEntity(final PaymentID aPaymentId) {
        this.id = aPaymentId.getValue();
    }

    public static PaymentJpaEntity from(final PaymentID aPaymentId) {
        return new PaymentJpaEntity(aPaymentId);
    }

    public static PaymentJpaEntity from(final Payment aPayment) {
        return new PaymentJpaEntity(
                aPayment.getId().getValue(),
                aPayment.getType().name(),
                aPayment.getAmount(),
                Objects.nonNull(aPayment.getCard()) ? CardJpaEntity.from(aPayment.getCard()) : null,
                Objects.nonNull(aPayment.getBillet()) ? BilletJpaEntity.from(aPayment.getBillet()) : null,
                Objects.nonNull(aPayment.getPix()) ? PixJpaEntity.from(aPayment.getPix()) : null
        );
    }

    public Payment toAggregate() {
        return Payment.with(
                PaymentID.from(getId()),
                getType(),
                getAmount(),
                Objects.nonNull(getCard()) ? CardID.from(getCard().getId()) : null,
                Objects.nonNull(getBillet()) ? BilletID.from(getBillet().getId()) : null,
                Objects.nonNull(getPix()) ? PixID.from(getPix().getId()) : null
        );
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
