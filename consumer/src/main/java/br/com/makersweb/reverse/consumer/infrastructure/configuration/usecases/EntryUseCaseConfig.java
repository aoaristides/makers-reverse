package br.com.makersweb.reverse.consumer.infrastructure.configuration.usecases;

import br.com.makersweb.reverse.consumer.application.entries.create.CreateEntryUseCase;
import br.com.makersweb.reverse.consumer.application.entries.create.DefaultCreateEntryUseCase;
import br.com.makersweb.reverse.consumer.domain.entries.EntryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class EntryUseCaseConfig {

    private final EntryGateway entryGateway;

    public EntryUseCaseConfig(final EntryGateway entryGateway) {
        this.entryGateway = entryGateway;
    }

    @Bean
    public CreateEntryUseCase createEntryUseCase() {
        return new DefaultCreateEntryUseCase(entryGateway);
    }
}
