package br.com.makersweb.reverse.consumer.infrastructure.reverse.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author aaristides
 */
public interface ReverseRepository extends JpaRepository<ReverseJpaEntity, String> {

    @Query(value = "SELECT r.id FROM Reverse r WHERE r.id IN :ids")
    List<String> existsByIds(@Param("ids") List<String> ids);

}
