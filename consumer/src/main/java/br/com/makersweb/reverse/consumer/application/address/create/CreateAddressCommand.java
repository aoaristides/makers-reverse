package br.com.makersweb.reverse.consumer.application.address.create;

/**
 * @author aaristides
 * @param streetName
 * @param streetNumber
 * @param city
 * @param district
 * @param complement
 * @param postalCode
 */
public record CreateAddressCommand(
        String streetName,
        String streetNumber,
        String city,
        String district,
        String complement,
        String postalCode
) {

    public static CreateAddressCommand with(
            final String aStreetName,
            final String aStreetNumber,
            final String aCity,
            final String aDistrict,
            final String aComplement,
            final String aPostalCode
    ) {
        return new CreateAddressCommand(aStreetName, aStreetNumber, aCity, aDistrict, aComplement, aPostalCode);
    }

}
