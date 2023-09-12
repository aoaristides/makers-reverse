package br.com.makersweb.reverse.consumer.infrastructure.reverse;

import br.com.makersweb.reverse.consumer.domain.reverse.Reverse;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseGateway;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseID;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.persistence.ReverseJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.persistence.ReverseRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author aaristides
 */
@Component
public class ReverseMySQLGateway implements ReverseGateway {

    private final ReverseRepository repository;

    public ReverseMySQLGateway(final ReverseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reverse create(final Reverse aReverse) {
        return save(aReverse);
    }

    @Override
    public Optional<Reverse> findById(final ReverseID anId) {
        return Optional.empty();
    }

    private Reverse save(final Reverse aReverse) {
        return this.repository.save(ReverseJpaEntity.from(aReverse)).toAggregate();
    }
}
