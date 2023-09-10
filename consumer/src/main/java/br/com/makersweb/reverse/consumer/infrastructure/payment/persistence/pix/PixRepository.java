package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.pix;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface PixRepository extends JpaRepository<PixJpaEntity, String> {
}
