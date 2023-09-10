package br.com.makersweb.reverse.consumer.infrastructure.entries;

import br.com.makersweb.reverse.consumer.domain.entries.Entry;
import br.com.makersweb.reverse.consumer.domain.entries.EntryGateway;
import br.com.makersweb.reverse.consumer.infrastructure.entries.persistence.EntryRepository;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
public class EntryMySQLGateway implements EntryGateway {

    private final EntryRepository repository;

    public EntryMySQLGateway(final EntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Entry create(final Entry aEntry) {
        return null;
    }
}
