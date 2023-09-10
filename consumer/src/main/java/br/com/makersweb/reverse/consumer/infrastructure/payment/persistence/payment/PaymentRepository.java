package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.payment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface PaymentRepository extends JpaRepository<PaymentJpaEntity, String> {
}
