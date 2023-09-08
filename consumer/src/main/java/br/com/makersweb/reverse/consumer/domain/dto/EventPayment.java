package br.com.makersweb.reverse.consumer.domain.dto;

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
public record EventPayment(
        @JsonProperty("type") String type,
        @JsonProperty("amount") BigDecimal amount,
        @JsonProperty("card") EventPaymentCard card,
        @JsonProperty("billet") EventPaymentBillet billet,
        @JsonProperty("pix") EventPaymentPix pix
) {
}
