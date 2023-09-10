package br.com.makersweb.reverse.consumer.infrastructure.customer;

import br.com.makersweb.reverse.consumer.domain.customer.Customer;
import br.com.makersweb.reverse.consumer.domain.customer.CustomerGateway;
import br.com.makersweb.reverse.consumer.infrastructure.customer.persistence.CustomerRepository;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
public class CustomerMySQLGateway implements CustomerGateway {

    private final CustomerRepository repository;

    public CustomerMySQLGateway(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(final Customer aCustomer) {
        return null;
    }
}
