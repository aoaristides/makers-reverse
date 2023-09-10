package br.com.makersweb.reverse.consumer.application.customer.create;

import br.com.makersweb.reverse.consumer.domain.customer.Customer;

/**
 * @author aaristides
 * @param id
 */
public record CreateCustomerOutput(
        String id
) {

    public static CreateCustomerOutput from(final String anId) {
        return new CreateCustomerOutput(anId);
    }

    public static CreateCustomerOutput from(final Customer aCustomer) {
        return new CreateCustomerOutput(aCustomer.getId().getValue());
    }

}
