package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.billet.account.Account;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountGateway;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountID;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.account.AccountJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.account.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author aaristides
 */
@Component
public class AccountMySQLGateway implements AccountGateway {

    private final AccountRepository repository;

    public AccountMySQLGateway(final AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account create(final Account aAccount) {
        return save(aAccount);
    }

    @Override
    public Optional<Account> findById(final AccountID anId) {
        return this.repository.findById(anId.getValue()).map(AccountJpaEntity::toAggregate);
    }

    private Account save(final Account aAccount) {
        return this.repository.save(AccountJpaEntity.from(aAccount)).toAggregate();
    }
}
