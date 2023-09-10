package br.com.makersweb.reverse.consumer.domain.reverse;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.address.AddressID;
import br.com.makersweb.reverse.consumer.domain.customer.CustomerID;
import br.com.makersweb.reverse.consumer.domain.entries.EntryID;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentID;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author aaristides
 */
public class Reverse extends AggregateRoot<ReverseID> {

    private String originalOrder;
    private String reverseOrder;
    private ReverseType type;
    private LocalDateTime createdOrder;
    private LocalDateTime createdReverse;
    private BigDecimal deliveryCost;
    private BigDecimal discount;
    private BigDecimal totalValue;
    private LocalDate estimatedDeliveryTime;
    private LocalDate deliveryDate;
    private String deliveryMode;
    private CustomerID customer;
    private AddressID deliveryAddress;
    private List<EntryID> entries;
    private PaymentID payment;
    private Instant createdAt;

    private Reverse(
            final ReverseID anId,
            final String aOriginalOrder,
            final String aReverseOrder,
            final ReverseType aType,
            final LocalDateTime aCreatedOrder,
            final LocalDateTime aCreatedReverse,
            final BigDecimal aDeliveryCost,
            final BigDecimal aDiscount,
            final BigDecimal aTotalValue,
            final LocalDate aEstimatedDeliveryTime,
            final LocalDate aDeliveryDate,
            final String aDeliveryMode,
            final CustomerID aCustomer,
            final AddressID aDeliveryAddress,
            final List<EntryID> aEntries,
            final PaymentID aPaymentID,
            final Instant aCreationDate
    ) {
        super(anId);
        this.originalOrder = aOriginalOrder;
        this.reverseOrder = aReverseOrder;
        this.type = aType;
        this.createdOrder = aCreatedOrder;
        this.createdReverse = aCreatedReverse;
        this.deliveryCost = aDeliveryCost;
        this.discount = aDiscount;
        this.totalValue = aTotalValue;
        this.estimatedDeliveryTime = aEstimatedDeliveryTime;
        this.deliveryDate = aDeliveryDate;
        this.deliveryMode = aDeliveryMode;
        this.customer = aCustomer;
        this.deliveryAddress = aDeliveryAddress;
        this.entries = aEntries;
        this.payment = aPaymentID;
        this.createdAt = aCreationDate;
    }

    public static Reverse newReverse(
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
            final CustomerID aCustomer,
            final AddressID aDeliveryAddress,
            final List<EntryID> aEntries,
            final PaymentID aPaymentID
    ) {
        final var anId = ReverseID.unique();
        final var now = Instant.now();
        final var type = reverseTypeFromString(aType);
        return new Reverse(
                anId,
                aOriginalOrder,
                aReverseOrder,
                type,
                aCreatedOrder,
                aCreatedReverse,
                aDeliveryCost,
                aDiscount,
                aTotalValue,
                aEstimatedDeliveryTime,
                aDeliveryDate,
                aDeliveryMode,
                aCustomer,
                aDeliveryAddress,
                aEntries,
                aPaymentID,
                now
        );
    }

    public static Reverse with(
            final ReverseID anId,
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
            final CustomerID aCustomer,
            final AddressID aDeliveryAddress,
            final List<EntryID> aEntries,
            final PaymentID aPaymentID,
            final Instant aCreationDate
    ) {
        final var type = reverseTypeFromString(aType);
        return new Reverse(
                anId,
                aOriginalOrder,
                aReverseOrder,
                type,
                aCreatedOrder,
                aCreatedReverse,
                aDeliveryCost,
                aDiscount,
                aTotalValue,
                aEstimatedDeliveryTime,
                aDeliveryDate,
                aDeliveryMode,
                aCustomer,
                aDeliveryAddress,
                aEntries,
                aPaymentID,
                aCreationDate
        );
    }

    public static Reverse with(final Reverse aReverse) {
        return with(
                aReverse.id,
                aReverse.originalOrder,
                aReverse.reverseOrder,
                aReverse.type.name(),
                aReverse.createdOrder,
                aReverse.createdReverse,
                aReverse.deliveryCost,
                aReverse.discount,
                aReverse.totalValue,
                aReverse.estimatedDeliveryTime,
                aReverse.deliveryDate,
                aReverse.deliveryMode,
                aReverse.customer,
                aReverse.deliveryAddress,
                aReverse.entries,
                aReverse.payment,
                aReverse.createdAt
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {

    }

    private static ReverseType reverseTypeFromString(final String value) {
        return Arrays.stream(ReverseType.values())
                .filter(type -> type.name().equalsIgnoreCase(value))
                .findFirst().orElse(null);
    }

    public ReverseID getId() {
        return id;
    }

    public String getOriginalOrder() {
        return originalOrder;
    }

    public String getReverseOrder() {
        return reverseOrder;
    }

    public ReverseType getType() {
        return type;
    }

    public LocalDateTime getCreatedOrder() {
        return createdOrder;
    }

    public LocalDateTime getCreatedReverse() {
        return createdReverse;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public LocalDate getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public CustomerID getCustomer() {
        return customer;
    }

    public AddressID getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<EntryID> getEntries() {
        return entries;
    }

    public PaymentID getPayment() {
        return payment;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
