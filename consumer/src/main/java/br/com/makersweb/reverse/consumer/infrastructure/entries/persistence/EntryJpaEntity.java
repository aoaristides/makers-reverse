package br.com.makersweb.reverse.consumer.infrastructure.entries.persistence;

import br.com.makersweb.reverse.consumer.domain.entries.Entry;
import br.com.makersweb.reverse.consumer.domain.entries.EntryID;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.persistence.ReverseJpaEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author aaristides
 */
@Entity(name = "Entry")
@Table(name = "entry")
public class EntryJpaEntity {

    @Id
    private String id;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    private ReverseJpaEntity reverse;

    public EntryJpaEntity() {
    }

    private EntryJpaEntity(
            String id,
            String productCode,
            String productName,
            Integer quantity,
            BigDecimal basePrice,
            BigDecimal totalPrice,
            String size,
            String url
    ) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
        this.basePrice = basePrice;
        this.totalPrice = totalPrice;
        this.size = size;
        this.url = url;
    }

    private EntryJpaEntity(final EntryID aEntryId) {
        this.id = aEntryId.getValue();
    }

    public static EntryJpaEntity from(final EntryID aEntryId) {
        return new EntryJpaEntity(aEntryId);
    }

    public static EntryJpaEntity from(final Entry aEntry) {
        return new EntryJpaEntity(
                aEntry.getId().getValue(),
                aEntry.getProductCode(),
                aEntry.getProductName(),
                aEntry.getQuantity(),
                aEntry.getBasePrice(),
                aEntry.getTotalPrice(),
                aEntry.getSize(),
                aEntry.getUrl()
        );
    }

    public Entry toAggregate() {
        return Entry.with(
                EntryID.from(getId()),
                getProductCode(),
                getProductName(),
                getQuantity(),
                getBasePrice(),
                getTotalPrice(),
                getSize(),
                getUrl()
        );
    }

    public String getId() {
        return id;
    }

    public EntryJpaEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getProductCode() {
        return productCode;
    }

    public EntryJpaEntity setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public EntryJpaEntity setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public EntryJpaEntity setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public EntryJpaEntity setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public EntryJpaEntity setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public String getSize() {
        return size;
    }

    public EntryJpaEntity setSize(String size) {
        this.size = size;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public EntryJpaEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public ReverseJpaEntity getReverse() {
        return reverse;
    }

    public void setReverse(ReverseJpaEntity reverse) {
        this.reverse = reverse;
    }
}
