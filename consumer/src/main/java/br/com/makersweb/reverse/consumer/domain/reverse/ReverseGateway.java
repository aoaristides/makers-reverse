package br.com.makersweb.reverse.consumer.domain.reverse;

import java.util.Optional;

/**
 * @author aaristides
 */
public interface ReverseGateway {

    Reverse create(final Reverse aReverse);

    Optional<Reverse> findById(final ReverseID anId);

}
