package br.com.makersweb.reverse.consumer.infrastructure.address.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface AddressRepository extends JpaRepository<AddressJpaEntity, String> {
}
