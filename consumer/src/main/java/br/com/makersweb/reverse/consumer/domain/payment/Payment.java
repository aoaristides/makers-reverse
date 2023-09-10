package br.com.makersweb.reverse.consumer.domain.payment;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.payment.billet.Billet;
import br.com.makersweb.reverse.consumer.domain.payment.card.Card;
import br.com.makersweb.reverse.consumer.domain.payment.pix.Pix;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

import java.math.BigDecimal;

/**
 * @author aaristides
 */
public class Payment extends AggregateRoot<PaymentID> {

    private PaymentType type;
    private BigDecimal amount;
    private Card card;
    private Billet billet;
    private Pix pix;

    private Payment(
            final PaymentID anId,
            final PaymentType aType,
            final BigDecimal aAmount,
            final Card aCard,
            final Billet aBillet,
            final Pix aPix
    ) {
        super(anId);
        this.type = aType;
        this.amount = aAmount;
        this.card = aCard;
        this.billet = aBillet;
        this.pix = aPix;
    }

    public static Payment newPayment(
            final PaymentType aType,
            final BigDecimal aAmount,
            final Card aCard,
            final Billet aBillet,
            final Pix aPix
    ) {
        final var anId = PaymentID.unique();
        return new Payment(
                anId,
                aType,
                aAmount,
                aCard,
                aBillet,
                aPix
        );
    }

    public static Payment with(
            final PaymentID anId,
            final PaymentType aType,
            final BigDecimal aAmount,
            final Card aCard,
            final Billet aBillet,
            final Pix aPix
    ) {
        return new Payment(
                anId,
                aType,
                aAmount,
                aCard,
                aBillet,
                aPix
        );
    }

    public static Payment with(final Payment payment) {
        return with(
                payment.getId(),
                payment.type,
                payment.amount,
                payment.card,
                payment.billet,
                payment.pix
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {

    }

    public PaymentID getId() {
        return id;
    }

    public PaymentType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Card getCard() {
        return card;
    }

    public Billet getBillet() {
        return billet;
    }

    public Pix getPix() {
        return pix;
    }
}
