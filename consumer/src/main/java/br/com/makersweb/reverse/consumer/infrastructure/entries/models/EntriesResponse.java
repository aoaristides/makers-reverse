package br.com.makersweb.reverse.consumer.infrastructure.entries.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param id
 * @param productCode
 * @param productName
 * @param quantity
 * @param basePrice
 * @param totalPrice
 * @param size
 * @param url
 */
public record EntriesResponse(
        @JsonProperty("id") String id,
        @JsonProperty("product_code") String productCode,
        @JsonProperty("product_name") String productName,
        @JsonProperty("quantity") Integer quantity,
        @JsonProperty("base_price") BigDecimal basePrice,
        @JsonProperty("total_price") BigDecimal totalPrice,
        @JsonProperty("size") String size,
        @JsonProperty("url") String url
) {
}
