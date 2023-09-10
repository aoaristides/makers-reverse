package br.com.makersweb.reverse.consumer.application.reverse.retrieve.get;

import br.com.makersweb.reverse.consumer.domain.entries.EntryID;
import br.com.makersweb.reverse.consumer.domain.reverse.Reverse;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseID;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseType;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author aaristides
 * @param id
 * @param ariginalOrder
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
 * @param createdAt
 */
public record ReverseOutput(
        ReverseID id,
        String ariginalOrder,
        String reverseOrder,
        ReverseType type,
        LocalDateTime createdOrder,
        LocalDateTime createdReverse,
        BigDecimal deliveryCost,
        BigDecimal discount,
        BigDecimal totalValue,
        LocalDate estimatedDeliveryTime,
        LocalDate deliveryDate,
        String deliveryMode,
        String customer,
        String deliveryAddress,
        List<String> entries,
        String payment,
        Instant createdAt
) {

    public static ReverseOutput from(final Reverse aReverse) {
        return new ReverseOutput(
                aReverse.getId(),
                aReverse.getOriginalOrder(),
                aReverse.getReverseOrder(),
                aReverse.getType(),
                aReverse.getCreatedOrder(),
                aReverse.getCreatedReverse(),
                aReverse.getDeliveryCost(),
                aReverse.getDiscount(),
                aReverse.getTotalValue(),
                aReverse.getEstimatedDeliveryTime(),
                aReverse.getDeliveryDate(),
                aReverse.getDeliveryMode(),
                aReverse.getCustomer().getValue(),
                aReverse.getDeliveryAddress().getValue(),
                aReverse.getEntries().stream()
                        .map(EntryID::getValue)
                        .toList(),
                aReverse.getPayment().getValue(),
                aReverse.getCreatedAt()
        );
    }

}
