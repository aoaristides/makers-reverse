package br.com.makersweb.reverse.consumer.infrastructure.reverse.models;

import br.com.makersweb.reverse.consumer.infrastructure.address.models.AddressResponse;
import br.com.makersweb.reverse.consumer.infrastructure.customer.models.CustomerResponse;
import br.com.makersweb.reverse.consumer.infrastructure.entries.models.EntriesResponse;
import br.com.makersweb.reverse.consumer.infrastructure.payment.models.PaymentResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author aaristides
 * @param id
 * @param originalOrder
 * @param reverseOrder
 * @param type
 * @param createdOrder
 * @param createdReverse
 * @param deliveryCost
 * @param discount
 * @param totalValue
 * @param estimatedDeliveryTime
 * @param deliveryDate
 * @param deliveryMode
 * @param customer
 * @param deliveryAddress
 * @param entries
 * @param payment
 */
public record ReverseResponse(
        @JsonProperty("id") String id,
        @JsonProperty("original_order") String originalOrder,
        @JsonProperty("reverse_order") String reverseOrder,
        @JsonProperty("type") String type,
        @JsonProperty("created_order") LocalDateTime createdOrder,
        @JsonProperty("created_reverse") LocalDateTime createdReverse,
        @JsonProperty("delivery_cost") BigDecimal deliveryCost,
        @JsonProperty("discount") BigDecimal discount,
        @JsonProperty("total_value") BigDecimal totalValue,
        @JsonProperty("estimated_delivery_time") LocalDate estimatedDeliveryTime,
        @JsonProperty("delivery_date") LocalDate deliveryDate,
        @JsonProperty("delivery_mode") String deliveryMode,
        @JsonProperty("customer") CustomerResponse customer,
        @JsonProperty("delivery_address") AddressResponse deliveryAddress,
        @JsonProperty("entries") List<EntriesResponse> entries,
        @JsonProperty("payment") PaymentResponse payment
) {
}
