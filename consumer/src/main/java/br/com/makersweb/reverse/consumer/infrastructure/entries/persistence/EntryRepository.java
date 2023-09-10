package br.com.makersweb.reverse.consumer.infrastructure.entries.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface EntryRepository extends JpaRepository<EntryJpaEntity, String> {
}
