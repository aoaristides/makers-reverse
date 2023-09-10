package br.com.makersweb.reverse.consumer.application.reverse.create;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author aaristides
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
 * @param address
 * @param entries
 * @param payment
 */
public record CreateReverseCommand(
        String originalOrder,
        String reverseOrder,
        String type,
        LocalDateTime createdOrder,
        LocalDateTime createdReverse,
        BigDecimal deliveryCost,
        BigDecimal discount,
        BigDecimal totalValue,
        LocalDate estimatedDeliveryTime,
        LocalDate deliveryDate,
        String deliveryMode,
        String customer,
        String address,
        List<String> entries,
        String payment
) {

    public static CreateReverseCommand with(
            final String aOriginalOrder,
            final String aReverseOrder,
            final String aType,
            final LocalDateTime aCreatedOrder,
            final LocalDateTime aCreatedReverse,
            final BigDecimal aDeliveryCost,
            final BigDecimal aDiscount,
            final BigDecimal aTotalValue,
            final LocalDate aEstimatedDeliveryTime,
            final LocalDate aDeliveryDate,
            final String aDeliveryMode,
            final String aCustomer,
            final String aAddress,
            final List<String> aEntries,
            final String aPayment
    ) {
        return new CreateReverseCommand(
                aOriginalOrder,
                aReverseOrder,
                aType,
                aCreatedOrder,
                aCreatedReverse,
                aDeliveryCost,
                aDiscount,
                aTotalValue,
                aEstimatedDeliveryTime,
                aDeliveryDate,
                aDeliveryMode,
                aCustomer,
                aAddress,
                aEntries,
                aPayment
        );
    }

}
