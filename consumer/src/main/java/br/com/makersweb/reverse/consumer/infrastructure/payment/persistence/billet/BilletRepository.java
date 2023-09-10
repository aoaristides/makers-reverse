package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface BilletRepository extends JpaRepository<BilletJpaEntity, String> {
}
