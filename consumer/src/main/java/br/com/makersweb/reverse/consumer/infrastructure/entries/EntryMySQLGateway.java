package br.com.makersweb.reverse.consumer.infrastructure.entries;

import br.com.makersweb.reverse.consumer.domain.entries.Entry;
import br.com.makersweb.reverse.consumer.domain.entries.EntryGateway;
import br.com.makersweb.reverse.consumer.infrastructure.entries.persistence.EntryJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.entries.persistence.EntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class EntryMySQLGateway implements EntryGateway {

    private final EntryRepository repository;

    public EntryMySQLGateway(final EntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Entry create(final Entry aEntry) {
        log.info("Init method create entry by product - {}", aEntry.getProductCode());
        return save(aEntry);
    }

    @Override
    public List<Entry> findByIds(final List<String> ids) {
        log.info("Init method findByIds with total ids - {}", ids.size());
        return this.repository.findByIds(ids)
                .stream()
                .map(EntryJpaEntity::toAggregate)
                .toList();
    }

    private Entry save(final Entry aEntry) {
        return this.repository.save(EntryJpaEntity.from(aEntry)).toAggregate();
    }
}
