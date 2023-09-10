package br.com.makersweb.reverse.consumer.infrastructure.payment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param type
 * @param amount
 * @param card
 * @param billet
 * @param pix
 */
public record PaymentRequest(
        @JsonProperty("type") String type,
        @JsonProperty("amount") BigDecimal amount,
        @JsonProperty("card") CardRequest card,
        @JsonProperty("billet") BilletRequest billet,
        @JsonProperty("pix") PixRequest pix
) {
}
