package br.com.makersweb.reverse.consumer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aaristides
 * @param cardNumber
 * @param holder
 * @param brand
 * @param expirationDate
 * @param securityCode
 * @param cardToken
 * @param installments
 * @param saveCard
 */
public record EventPaymentCard(
        @JsonProperty("card_number") String cardNumber,
        @JsonProperty("holder") String holder,
        @JsonProperty("brand") String brand,
        @JsonProperty("expiration_date") String expirationDate,
        @JsonProperty("security_code") String securityCode,
        @JsonProperty("card_token") String cardToken,
        @JsonProperty("installments") Integer installments,
        @JsonProperty("save_card") boolean saveCard
) {
}
