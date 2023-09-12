package br.com.makersweb.reverse.consumer.infrastructure.customer;

import br.com.makersweb.reverse.consumer.domain.customer.Customer;
import br.com.makersweb.reverse.consumer.domain.customer.CustomerGateway;
import br.com.makersweb.reverse.consumer.infrastructure.customer.persistence.CustomerJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.customer.persistence.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class CustomerMySQLGateway implements CustomerGateway {

    private final CustomerRepository repository;

    public CustomerMySQLGateway(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(final Customer aCustomer) {
        log.info("Init method create customer by id - {}", aCustomer.getId().getValue());
        return save(aCustomer);
    }

    private Customer save(final Customer aCustomer) {
        return this.repository.save(CustomerJpaEntity.from(aCustomer)).toAggregate();
    }
}
