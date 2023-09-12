package br.com.makersweb.reverse.consumer.infrastructure.address;

import br.com.makersweb.reverse.consumer.domain.address.Address;
import br.com.makersweb.reverse.consumer.domain.address.AddressGateway;
import br.com.makersweb.reverse.consumer.infrastructure.address.persistence.AddressJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.address.persistence.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class AddressMySQLGateway implements AddressGateway {

    private final AddressRepository repository;

    public AddressMySQLGateway(final AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(final Address aAddress) {
        log.info("Init method create address by id - {}", aAddress.getId().getValue());
        return save(aAddress);
    }

    private Address save(final Address aAddress) {
        return this.repository.save(AddressJpaEntity.from(aAddress)).toAggregate();
    }
}
