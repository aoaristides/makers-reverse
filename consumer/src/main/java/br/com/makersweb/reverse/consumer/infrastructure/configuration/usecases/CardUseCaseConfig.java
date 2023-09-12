package br.com.makersweb.reverse.consumer.infrastructure.configuration.usecases;

import br.com.makersweb.reverse.consumer.application.payment.create.CreateCardUseCase;
import br.com.makersweb.reverse.consumer.application.payment.create.DefaultCreateCardUseCase;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class CardUseCaseConfig {

    private final CardGateway cardGateway;

    public CardUseCaseConfig(final CardGateway cardGateway) {
        this.cardGateway = cardGateway;
    }

    @Bean
    public CreateCardUseCase createCardUseCase() {
        return new DefaultCreateCardUseCase(cardGateway);
    }
}
