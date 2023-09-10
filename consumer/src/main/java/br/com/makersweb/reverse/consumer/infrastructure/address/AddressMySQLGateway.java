package br.com.makersweb.reverse.consumer.infrastructure.address;

import br.com.makersweb.reverse.consumer.domain.address.Address;
import br.com.makersweb.reverse.consumer.domain.address.AddressGateway;
import br.com.makersweb.reverse.consumer.infrastructure.address.persistence.AddressRepository;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
public class AddressMySQLGateway implements AddressGateway {

    private final AddressRepository repository;

    public AddressMySQLGateway(final AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(final Address aAddress) {
        return null;
    }
}
