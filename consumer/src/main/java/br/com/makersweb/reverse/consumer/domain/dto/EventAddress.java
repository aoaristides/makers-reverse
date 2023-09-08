package br.com.makersweb.reverse.consumer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aaristides
 * @param streetName
 * @param streetNumber
 * @param city
 * @param district
 * @param postalCode
 * @param complement
 */
public record EventAddress(
        @JsonProperty("street_name") String streetName,
        @JsonProperty("street_number") String streetNumber,
        @JsonProperty("city") String city,
        @JsonProperty("district") String district,
        @JsonProperty("postal_code") String postalCode,
        @JsonProperty("complement") String complement
) {
}
