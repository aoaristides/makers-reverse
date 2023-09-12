package br.com.makersweb.reverse.consumer.infrastructure.entries.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author aaristides
 */
public interface EntryRepository extends JpaRepository<EntryJpaEntity, String> {

    @Query(value = "select e from Entry e where e.id in :ids")
    List<EntryJpaEntity> findByIds(@Param("ids") List<String> ids);

}
