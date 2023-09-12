package br.com.makersweb.reverse.consumer.infrastructure.configuration.usecases;

import br.com.makersweb.reverse.consumer.application.payment.create.CreateBilletUseCase;
import br.com.makersweb.reverse.consumer.application.payment.create.DefaultCreateBilletUseCase;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletGateway;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class BilletUseCaseConfig {

    private final BilletGateway billetGateway;
    private final AccountGateway accountGateway;

    public BilletUseCaseConfig(
            final BilletGateway billetGateway,
            final AccountGateway accountGateway
    ) {
        this.billetGateway = billetGateway;
        this.accountGateway = accountGateway;
    }

    @Bean
    public CreateBilletUseCase createBilletUseCase() {
        return new DefaultCreateBilletUseCase(billetGateway, accountGateway);
    }
}
