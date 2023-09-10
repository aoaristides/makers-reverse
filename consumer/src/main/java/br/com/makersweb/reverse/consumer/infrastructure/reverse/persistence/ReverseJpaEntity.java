package br.com.makersweb.reverse.consumer.infrastructure.reverse.persistence;

import br.com.makersweb.reverse.consumer.domain.address.AddressID;
import br.com.makersweb.reverse.consumer.domain.customer.CustomerID;
import br.com.makersweb.reverse.consumer.domain.entries.EntryID;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentID;
import br.com.makersweb.reverse.consumer.domain.reverse.Reverse;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseID;
import br.com.makersweb.reverse.consumer.infrastructure.address.persistence.AddressJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.customer.persistence.CustomerJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.entries.persistence.EntryJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.payment.PaymentJpaEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * @author aaristides
 */
@Entity(name = "Reverse")
@Table(name = "reverse")
public class ReverseJpaEntity {

    @Id
    private String id;

    @Column(name = "original_order", nullable = false)
    private String originalOrder;

    @Column(name = "reverse_order", nullable = false)
    private String reverseOrder;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "created_order", nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdOrder;

    @Column(name = "created_reverse", nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdReverse;

    @Column(name = "delivery_cost", nullable = false)
    private BigDecimal deliveryCost;

    @Column(name = "discount", nullable = false)
    private BigDecimal discount;

    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @Column(name = "estimated_delivery_time", nullable = false)
    private LocalDate estimatedDeliveryTime;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "delivery_mode", nullable = false)
    private String deliveryMode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerJpaEntity customer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "delivery_address_id")
    private AddressJpaEntity deliveryAddress;

    @OneToMany(mappedBy = "reverse", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    private List<EntryJpaEntity> entries;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentJpaEntity payment;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    public ReverseJpaEntity() {
    }

    private ReverseJpaEntity(
            final String anId,
            final String originalOrder,
            final String reverseOrder,
            final String type,
            final LocalDateTime createdOrder,
            final LocalDateTime createdReverse,
            final BigDecimal deliveryCost,
            final BigDecimal discount,
            final BigDecimal totalValue,
            final LocalDate estimatedDeliveryTime,
            final LocalDate deliveryDate,
            final String deliveryMode,
            final CustomerJpaEntity customer,
            final AddressJpaEntity deliveryAddress,
            final PaymentJpaEntity payment,
            final Instant createdAt
    ) {
        this.id = anId;
        this.originalOrder = originalOrder;
        this.reverseOrder = reverseOrder;
        this.type = type;
        this.createdOrder = createdOrder;
        this.createdReverse = createdReverse;
        this.deliveryCost = deliveryCost;
        this.discount = discount;
        this.totalValue = totalValue;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.deliveryDate = deliveryDate;
        this.deliveryMode = deliveryMode;
        this.entries = new ArrayList<>();
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.payment = payment;
        this.createdAt = createdAt;
    }

    public static ReverseJpaEntity from(final Reverse aReverse) {
        final var anEntity = new ReverseJpaEntity(
                aReverse.getId().getValue(),
                aReverse.getOriginalOrder(),
                aReverse.getReverseOrder(),
                aReverse.getType().name(),
                aReverse.getCreatedOrder(),
                aReverse.getCreatedReverse(),
                aReverse.getDeliveryCost(),
                aReverse.getDiscount(),
                aReverse.getTotalValue(),
                aReverse.getEstimatedDeliveryTime(),
                aReverse.getDeliveryDate(),
                aReverse.getDeliveryMode(),
                CustomerJpaEntity.from(aReverse.getCustomer()),
                AddressJpaEntity.from(aReverse.getDeliveryAddress()),
                PaymentJpaEntity.from(aReverse.getPayment()),
                aReverse.getCreatedAt()
        );

        aReverse.getEntries().forEach(anEntity::addEntry);

        return anEntity;
    }

    public Reverse toAggregate() {
        return Reverse.with(
                ReverseID.from(getId()),
                getOriginalOrder(),
                getReverseOrder(),
                getType(),
                getCreatedOrder(),
                getCreatedReverse(),
                getDeliveryCost(),
                getDiscount(),
                getTotalValue(),
                getEstimatedDeliveryTime(),
                getDeliveryDate(),
                getDeliveryMode(),
                getCustomerID(),
                getAddressID(),
                getEntryIDs(),
                getPaymentID(),
                getCreatedAt()
        );
    }

    private void addEntry(final EntryID anId) {
        this.entries.add(EntryJpaEntity.from(anId));
    }

    private void removeEntry(final EntryID anId) {
        this.entries.remove(EntryJpaEntity.from(anId));
    }

    public List<EntryID> getEntryIDs() {
        return getEntries().stream()
                .map(it -> EntryID.from(it.getId()))
                .toList();
    }

    public CustomerID getCustomerID() {
        return CustomerID.from(getCustomer().getId());
    }

    public AddressID getAddressID() {
        return AddressID.from(getDeliveryAddress().getId());
    }

    public PaymentID getPaymentID() {
        return PaymentID.from(getPayment().getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalOrder() {
        return originalOrder;
    }

    public void setOriginalOrder(String originalOrder) {
        this.originalOrder = originalOrder;
    }

    public String getReverseOrder() {
        return reverseOrder;
    }

    public void setReverseOrder(String reverseOrder) {
        this.reverseOrder = reverseOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedOrder() {
        return createdOrder;
    }

    public void setCreatedOrder(LocalDateTime createdOrder) {
        this.createdOrder = createdOrder;
    }

    public LocalDateTime getCreatedReverse() {
        return createdReverse;
    }

    public void setCreatedReverse(LocalDateTime createdReverse) {
        this.createdReverse = createdReverse;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDate estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public CustomerJpaEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerJpaEntity customer) {
        this.customer = customer;
    }

    public AddressJpaEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressJpaEntity deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<EntryJpaEntity> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryJpaEntity> entries) {
        this.entries = entries;
    }

    public PaymentJpaEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentJpaEntity payment) {
        this.payment = payment;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
