package br.com.makersweb.reverse.consumer.infrastructure.payment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param id
 * @param type
 * @param amount
 * @param card
 * @param billet
 * @param pix
 */
public record PaymentResponse(
        @JsonProperty("id") String id,
        @JsonProperty("type") String type,
        @JsonProperty("amount") BigDecimal amount,
        @JsonProperty("card") CardResponse card,
        @JsonProperty("billet") BilletResponse billet,
        @JsonProperty("pix") PixResponse pix
) {
}
