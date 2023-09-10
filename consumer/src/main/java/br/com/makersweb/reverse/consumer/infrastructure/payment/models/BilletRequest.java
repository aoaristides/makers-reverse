package br.com.makersweb.reverse.consumer.infrastructure.payment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * @author aaristides
 * @param expirationDate
 * @param daysToExpire
 * @param link
 * @param barCode
 * @param account
 */
public record BilletRequest(
        @JsonProperty("expiration_date") LocalDate expirationDate,
        @JsonProperty("days_to_expire") Integer daysToExpire,
        @JsonProperty("link") String link,
        @JsonProperty("bar_code") String barCode,
        @JsonProperty("account") AccountRequest account
) {
}
