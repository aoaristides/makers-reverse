package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.Payment;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentGateway;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletGateway;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardGateway;
import br.com.makersweb.reverse.consumer.domain.payment.pix.PixGateway;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.payment.PaymentRepository;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
public class PaymentMySQLGateway implements PaymentGateway {

    private final PaymentRepository repository;
    private final PixGateway pixGateway;
    private final CardGateway cardGateway;
    private final BilletGateway billetGateway;

    public PaymentMySQLGateway(
            final PaymentRepository repository,
            final PixGateway pixGateway,
            final CardGateway cardGateway,
            final BilletGateway billetGateway
    ) {
        this.repository = repository;
        this.pixGateway = pixGateway;
        this.cardGateway = cardGateway;
        this.billetGateway = billetGateway;
    }

    @Override
    public Payment create(final Payment aPayment) {
        return null;
    }
}
