package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.card;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface CardRepository extends JpaRepository<CardJpaEntity, String> {
}
