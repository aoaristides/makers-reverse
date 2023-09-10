package br.com.makersweb.reverse.consumer.domain.payment.billet.account;

import java.util.Optional;

/**
 * @author aaristides
 */
public interface AccountGateway {

    Account create(final Account aAccount);

    Optional<Account> findById(final AccountID anId);

}
