package br.com.makersweb.reverse.consumer.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author aaristides
 */
@Getter
public class Reverse {

    private String originalOrder;
    private String reverseOrder;
    private OrderType type;
    private LocalDateTime createdOrder;
    private Instant createdAtReverse;
    private BigDecimal deliveryCost;
    private BigDecimal totalDiscount;
    private BigDecimal totalValue;
    private LocalDate estimatedDeliveryTime;
    private LocalDate deliveryDate;
    private String trackingUrl;
    private String orderUrl;
    private String deliveryMode;
    private Customer customer;
    private Address deliveryAddress;
    private List<Entries> entries;
    private Reversal reversal;
    private Payment payment;

    private Reverse(String originalOrder, String reverseOrder, OrderType type, LocalDateTime createdOrder, Instant createdAtReverse, BigDecimal deliveryCost, BigDecimal totalDiscount, BigDecimal totalValue, LocalDate estimatedDeliveryTime, LocalDate deliveryDate, String trackingUrl, String orderUrl, String deliveryMode, Customer customer, Address deliveryAddress, List<Entries> entries, Reversal reversal, Payment payment) {
        this.originalOrder = originalOrder;
        this.reverseOrder = reverseOrder;
        this.type = type;
        this.createdOrder = createdOrder;
        this.createdAtReverse = createdAtReverse;
        this.deliveryCost = deliveryCost;
        this.totalDiscount = totalDiscount;
        this.totalValue = totalValue;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.deliveryDate = deliveryDate;
        this.trackingUrl = trackingUrl;
        this.orderUrl = orderUrl;
        this.deliveryMode = deliveryMode;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.entries = entries;
        this.reversal = reversal;
        this.payment = payment;
    }

    public static Reverse newReverse(
            final String aOriginalOrder,
            final String aReverseOrder,
            final String aType,
            final LocalDateTime aCreatedOrder,
            final BigDecimal aDeliveryCost,
            final BigDecimal aTotalDiscount,
            final BigDecimal aTotalValue,
            final LocalDate aEstimatedDeliveryTime,
            final LocalDate aDeliveryDate,
            final String aTrackingUrl,
            final String aOrderUrl,
            final String aDeliveryMode,
            final Customer aCustomer,
            final Address aDeliveryAddress,
            final List<Entries> aEntries,
            final Reversal aReversal,
            final Payment aPayment
    ) {
        final var now = Instant.now();
        final var type = Arrays.stream(OrderType.values()).filter(t -> t.name().equalsIgnoreCase(aType)).findFirst().orElse(null);
        return new Reverse(
                aOriginalOrder,
                aReverseOrder,
                type,
                aCreatedOrder,
                now,
                aDeliveryCost,
                aTotalDiscount,
                aTotalValue,
                aEstimatedDeliveryTime,
                aDeliveryDate,
                aTrackingUrl,
                aOrderUrl,
                aDeliveryMode,
                aCustomer,
                aDeliveryAddress,
                aEntries,
                aReversal,
                aPayment
        );
    }

}
