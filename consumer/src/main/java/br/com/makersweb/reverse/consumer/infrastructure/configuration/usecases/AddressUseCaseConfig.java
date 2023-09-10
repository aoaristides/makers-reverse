package br.com.makersweb.reverse.consumer.infrastructure.configuration.usecases;

import br.com.makersweb.reverse.consumer.application.address.create.CreateAddressUseCase;
import br.com.makersweb.reverse.consumer.application.address.create.DefaultCreateAddressUseCase;
import br.com.makersweb.reverse.consumer.domain.address.AddressGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class AddressUseCaseConfig {

    private final AddressGateway addressGateway;

    public AddressUseCaseConfig(final AddressGateway addressGateway) {
        this.addressGateway = addressGateway;
    }

    @Bean
    public CreateAddressUseCase createAddressUseCase() {
        return new DefaultCreateAddressUseCase(addressGateway);
    }
}
