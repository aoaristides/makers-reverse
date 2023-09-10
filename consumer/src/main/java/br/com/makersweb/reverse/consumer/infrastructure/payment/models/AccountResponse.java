package br.com.makersweb.reverse.consumer.infrastructure.payment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aaristides
 * @param id
 * @param agency
 * @param accountNumber
 * @param bankNumber
 * @param document
 * @param name
 * @param type
 */
public record AccountResponse(
        @JsonProperty("id") String id,
        @JsonProperty("agency") String agency,
        @JsonProperty("account_number") String accountNumber,
        @JsonProperty("bank_number") String bankNumber,
        @JsonProperty("document") String document,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type
) {
}
