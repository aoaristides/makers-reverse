package br.com.makersweb.reverse.consumer.infrastructure.configuration.usecases;

import br.com.makersweb.reverse.consumer.application.payment.create.CreatePixUseCase;
import br.com.makersweb.reverse.consumer.application.payment.create.DefaultCreatePixUseCase;
import br.com.makersweb.reverse.consumer.domain.payment.pix.PixGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class PixUseCaseConfig {

    private final PixGateway pixGateway;

    public PixUseCaseConfig(final PixGateway pixGateway) {
        this.pixGateway = pixGateway;
    }

    @Bean
    public CreatePixUseCase createPixUseCase() {
        return new DefaultCreatePixUseCase(pixGateway);
    }
}
