package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.Payment;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentGateway;

/**
 * @author aaristides
 */
public class DefaultCreatePaymentUseCase extends CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public DefaultCreatePaymentUseCase(final PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public CreatePaymentOutput execute(final CreatePaymentCommand aCommand) {
        final var type = aCommand.type();
        final var amount = aCommand.amount();
        final var card = aCommand.card();
        final var billet = aCommand.billet();
        final var pix = aCommand.pix();

        final var aPayment = Payment.newPayment(type, amount, card, billet, pix);

        return CreatePaymentOutput.from(this.paymentGateway.create(aPayment));
    }
}
