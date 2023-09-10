package br.com.makersweb.reverse.consumer.infrastructure.payment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * @author aaristides
 * @param id
 * @param expirationDate
 * @param daysToExpire
 * @param link
 * @param barCode
 * @param account
 */
public record BilletResponse(
        @JsonProperty("id") String id,
        @JsonProperty("expiration_date") LocalDate expirationDate,
        @JsonProperty("days_to_expire") Integer daysToExpire,
        @JsonProperty("link") String link,
        @JsonProperty("bar_code") String barCode,
        @JsonProperty("account") AccountResponse account
) {
}
