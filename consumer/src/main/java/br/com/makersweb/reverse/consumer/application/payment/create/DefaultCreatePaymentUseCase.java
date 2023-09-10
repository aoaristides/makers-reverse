package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.PaymentGateway;

import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultCreatePaymentUseCase extends CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public DefaultCreatePaymentUseCase(final PaymentGateway paymentGateway) {
        this.paymentGateway = Objects.requireNonNull(paymentGateway);
    }

    @Override
    public CreatePaymentOutput execute(final CreatePaymentCommand aCommand) {
        return null;
    }
}
