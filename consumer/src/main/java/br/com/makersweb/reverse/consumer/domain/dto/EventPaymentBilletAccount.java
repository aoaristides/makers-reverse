package br.com.makersweb.reverse.consumer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aaristides
 * @param agency
 * @param accountNumber
 * @param bankNumber
 * @param document
 * @param name
 * @param type
 */
public record EventPaymentBilletAccount(
        @JsonProperty("agency") String agency,
        @JsonProperty("account_number") String accountNumber,
        @JsonProperty("bank_number") String bankNumber,
        @JsonProperty("document") String document,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type
) {
}
