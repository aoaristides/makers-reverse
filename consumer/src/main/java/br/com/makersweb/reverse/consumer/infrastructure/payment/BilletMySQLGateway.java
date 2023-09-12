package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.billet.Billet;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletGateway;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.BilletJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.BilletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class BilletMySQLGateway implements BilletGateway {

    private final BilletRepository repository;

    public BilletMySQLGateway(final BilletRepository repository) {
        this.repository = repository;
    }

    @Override
    public Billet create(final Billet aBillet) {
        log.info("Init method create billet by id - {}", aBillet.getId().getValue());
        return save(aBillet);
    }

    private Billet save(final Billet aBillet) {
        return this.repository.save(BilletJpaEntity.from(aBillet)).toAggregate();
    }
}
