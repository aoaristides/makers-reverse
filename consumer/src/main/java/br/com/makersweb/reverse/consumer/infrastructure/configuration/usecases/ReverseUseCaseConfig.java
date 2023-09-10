package br.com.makersweb.reverse.consumer.infrastructure.configuration.usecases;

import br.com.makersweb.reverse.consumer.application.reverse.create.CreateReverseUseCase;
import br.com.makersweb.reverse.consumer.application.reverse.create.DefaultCreateReverseUseCase;
import br.com.makersweb.reverse.consumer.application.reverse.retrieve.get.DefaultGetReverseByIdUseCase;
import br.com.makersweb.reverse.consumer.application.reverse.retrieve.get.GetReverseByIdUseCase;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class ReverseUseCaseConfig {

    private final ReverseGateway reverseGateway;

    public ReverseUseCaseConfig(final ReverseGateway reverseGateway) {
        this.reverseGateway = reverseGateway;
    }

    @Bean
    public CreateReverseUseCase createReverseUseCase() {
        return new DefaultCreateReverseUseCase(reverseGateway);
    }

    @Bean
    public GetReverseByIdUseCase getReverseByIdUseCase() {
        return new DefaultGetReverseByIdUseCase(reverseGateway);
    }
}
