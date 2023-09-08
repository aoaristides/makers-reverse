package br.com.makersweb.reverse.consumer.domain.address;

import br.com.makersweb.reverse.consumer.domain.ValueObject;

/**
 * @author aaristides
 */
public class Address extends ValueObject {

    private String streetName;
    private String streetNumber;
    private String city;
    private String district;
    private String complement;
    private String postalCode;

    private Address(
            final String aStreetName,
            final String aStreetNumber,
            final String aCity,
            final String aDistrict,
            final String aComplement,
            final String aPostalCode
    ) {
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
        return new Address(aStreetName, aStreetNumber, aCity, aDistrict, aComplement, aPostalCode);
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
