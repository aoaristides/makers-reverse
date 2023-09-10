package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface AccountRepository extends JpaRepository<AccountJpaEntity, String> {



}
