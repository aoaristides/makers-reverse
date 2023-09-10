package br.com.makersweb.reverse.consumer.application.address.create;

import br.com.makersweb.reverse.consumer.domain.address.AddressGateway;

import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultCreateAddressUseCase extends CreateAddressUseCase {

    private final AddressGateway addressGateway;

    public DefaultCreateAddressUseCase(final AddressGateway addressGateway) {
        this.addressGateway = Objects.requireNonNull(addressGateway);
    }

    @Override
    public CreateAddressOutput execute(final CreateAddressCommand aCommand) {


        return null;
    }
}
