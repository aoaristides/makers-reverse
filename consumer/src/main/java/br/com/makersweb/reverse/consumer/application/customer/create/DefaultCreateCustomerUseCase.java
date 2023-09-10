package br.com.makersweb.reverse.consumer.application.customer.create;

import br.com.makersweb.reverse.consumer.domain.customer.Customer;
import br.com.makersweb.reverse.consumer.domain.customer.CustomerGateway;

import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultCreateCustomerUseCase extends CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public DefaultCreateCustomerUseCase(final CustomerGateway customerGateway) {
        this.customerGateway = Objects.requireNonNull(customerGateway);
    }

    @Override
    public CreateCustomerOutput execute(final CreateCustomerCommand aCommand) {
        final var name = aCommand.name();
        final var document = aCommand.document();
        final var phone = aCommand.phone();
        final var mail = aCommand.mail();
        final var birthday = aCommand.birthday();

        final var aCustomer = Customer.newCustomer(name, document, phone, mail, birthday);
        return CreateCustomerOutput.from(this.customerGateway.create(aCustomer));
    }
}
