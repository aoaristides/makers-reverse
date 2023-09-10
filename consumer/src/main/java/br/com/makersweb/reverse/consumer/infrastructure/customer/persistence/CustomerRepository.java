package br.com.makersweb.reverse.consumer.infrastructure.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface CustomerRepository extends JpaRepository<CustomerJpaEntity, String> {
}
