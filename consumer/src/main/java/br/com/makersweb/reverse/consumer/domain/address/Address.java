package br.com.makersweb.reverse.consumer.domain.address;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

/**
 * @author aaristides
 */
public class Address extends AggregateRoot<AddressID> {

    private String streetName;
    private String streetNumber;
    private String city;
    private String district;
    private String complement;
    private String postalCode;

    private Address(
            final AddressID anId,
            final String aStreetName,
            final String aStreetNumber,
            final String aCity,
            final String aDistrict,
            final String aComplement,
            final String aPostalCode
    ) {
        super(anId);
        this.streetName = aStreetName;
        this.streetNumber = aStreetNumber;
        this.city = aCity;
        this.district = aDistrict;
        this.complement = aComplement;
        this.postalCode = aPostalCode;
    }

    public static Address newAddress(
            final String aStreetName,
            final String aStreetNumber,
            final String aCity,
            final String aDistrict,
            final String aComplement,
            final String aPostalCode
    ) {
        final var anId = AddressID.unique();
        return new Address(anId, aStreetName, aStreetNumber, aCity, aDistrict, aComplement, aPostalCode);
    }

    public static Address with(
            final AddressID anId,
            final String aStreetName,
            final String aStreetNumber,
            final String aCity,
            final String aDistrict,
            final String aComplement,
            final String aPostalCode
    ) {
        return new Address(anId, aStreetName, aStreetNumber, aCity, aDistrict, aComplement, aPostalCode);
    }

    public static Address with(final Address address) {
        return with(
                address.getId(),
                address.streetName,
                address.streetNumber,
                address.city,
                address.district,
                address.complement,
                address.postalCode
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {

    }

    public AddressID getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getComplement() {
        return complement;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
