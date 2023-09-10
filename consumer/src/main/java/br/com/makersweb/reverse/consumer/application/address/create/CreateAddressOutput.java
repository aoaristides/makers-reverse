package br.com.makersweb.reverse.consumer.application.address.create;

import br.com.makersweb.reverse.consumer.domain.address.Address;

/**
 * @author aaristides
 * @param id
 */
public record CreateAddressOutput(
        String id
) {

    public static CreateAddressOutput from(final String anId) {
        return new CreateAddressOutput(anId);
    }

    public static CreateAddressOutput from(final Address aAddress) {
        return new CreateAddressOutput(aAddress.getId().getValue());
    }

}
