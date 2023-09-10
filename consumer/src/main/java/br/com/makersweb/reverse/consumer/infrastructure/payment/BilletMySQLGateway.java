package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.billet.Billet;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletGateway;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountGateway;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.BilletJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.BilletRepository;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
public class BilletMySQLGateway implements BilletGateway {

    private final BilletRepository repository;
    private final AccountGateway accountGateway;

    public BilletMySQLGateway(
            final BilletRepository repository,
            final AccountGateway accountGateway) {
        this.repository = repository;
        this.accountGateway = accountGateway;
    }

    @Override
    public Billet create(final Billet aBillet) {
        final var anAccountID = aBillet.getAccount();


        return null;
    }

    private Billet save(final Billet aBillet) {
        return this.repository.save(BilletJpaEntity.from(aBillet)).toAggregate();
    }
}
