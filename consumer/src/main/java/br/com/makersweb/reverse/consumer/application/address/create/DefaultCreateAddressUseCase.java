package br.com.makersweb.reverse.consumer.application.address.create;

import br.com.makersweb.reverse.consumer.domain.address.Address;
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
        final var streetName = aCommand.streetName();
        final var streetNumber = aCommand.streetNumber();
        final var city = aCommand.city();
        final var district = aCommand.district();
        final var complement = aCommand.complement();
        final var postalCode = aCommand.postalCode();

        final var aAddress = Address.newAddress(streetName, streetNumber, city, district, complement, postalCode);

        return CreateAddressOutput.from(this.addressGateway.create(aAddress));
    }
}
