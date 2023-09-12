package br.com.makersweb.reverse.consumer.infrastructure.configuration.usecases;

import br.com.makersweb.reverse.consumer.application.payment.create.CreatePaymentUseCase;
import br.com.makersweb.reverse.consumer.application.payment.create.DefaultCreatePaymentUseCase;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class PaymentUseCaseConfig {

    private final PaymentGateway paymentGateway;


    public PaymentUseCaseConfig(final PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Bean
    public CreatePaymentUseCase createPaymentUseCase() {
        return new DefaultCreatePaymentUseCase(paymentGateway);
    }
}
