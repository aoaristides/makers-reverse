package br.com.makersweb.reverse.consumer.domain.payment;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletID;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardID;
import br.com.makersweb.reverse.consumer.domain.payment.pix.PixID;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author aaristides
 */
public class Payment extends AggregateRoot<PaymentID> {

    private PaymentType type;
    private BigDecimal amount;
    private CardID card;
    private BilletID billet;
    private PixID pix;

    private Payment(
            final PaymentID anId,
            final PaymentType aType,
            final BigDecimal aAmount,
            final CardID aCard,
            final BilletID aBillet,
            final PixID aPix
    ) {
        super(anId);
        this.type = aType;
        this.amount = aAmount;
        this.card = aCard;
        this.billet = aBillet;
        this.pix = aPix;
    }

    public static Payment newPayment(
            final String aType,
            final BigDecimal aAmount,
            final String aCard,
            final String aBillet,
            final String aPix
    ) {
        final var anId = PaymentID.unique();
        final var type = paymentTypeFromString(aType);
        final var card = StringUtils.isNotEmpty(aCard) ? CardID.from(aCard) : null;
        final var billet = StringUtils.isNotEmpty(aBillet) ? BilletID.from(aBillet) : null;
        final var pix = StringUtils.isNotEmpty(aPix) ? PixID.from(aPix) : null;
        return new Payment(
                anId,
                type,
                aAmount,
                card,
                billet,
                pix
        );
    }

    public static Payment with(
            final PaymentID anId,
            final String aType,
            final BigDecimal aAmount,
            final CardID aCard,
            final BilletID aBillet,
            final PixID aPix
    ) {
        final var type = paymentTypeFromString(aType);
        return new Payment(
                anId,
                type,
                aAmount,
                aCard,
                aBillet,
                aPix
        );
    }

    public static Payment with(final Payment payment) {
        return with(
                payment.getId(),
                payment.type.name(),
                payment.amount,
                payment.card,
                payment.billet,
                payment.pix
        );
    }

    private static PaymentType paymentTypeFromString(final String aType) {
        return Arrays.stream(PaymentType.values())
                .filter(type -> aType.equalsIgnoreCase(type.name()))
                .findFirst().orElse(null);
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

    public CardID getCard() {
        return card;
    }

    public BilletID getBillet() {
        return billet;
    }

    public PixID getPix() {
        return pix;
    }
}
