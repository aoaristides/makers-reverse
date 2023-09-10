package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.pix.Pix;
import br.com.makersweb.reverse.consumer.domain.payment.pix.PixGateway;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.pix.PixRepository;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
public class PixMySQLGateway implements PixGateway {

    private final PixRepository repository;

    public PixMySQLGateway(final PixRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pix create(final Pix aPix) {
        return null;
    }
}
