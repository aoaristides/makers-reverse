package br.com.makersweb.reverse.consumer.domain.entries;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

import java.math.BigDecimal;

/**
 * @author aaristides
 */
public class Entry extends AggregateRoot<EntryID> {

    private String productCode;
    private String productName;
    private Integer quantity;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;
    private String size;
    private String url;

    private Entry(
            final EntryID anId,
            final String aProductCode,
            final String aProductName,
            final Integer aQuantity,
            final BigDecimal aBasePrice,
            final BigDecimal aTotalPrice,
            final String aSize,
            final String aUrl
    ) {
        super(anId);
        this.productCode = aProductCode;
        this.productName = aProductName;
        this.quantity = aQuantity;
        this.basePrice = aBasePrice;
        this.totalPrice = aTotalPrice;
        this.size = aSize;
        this.url = aUrl;
    }

    public static Entry newEntry(
            final String aProductCode,
            final String aProductName,
            final Integer aQuantity,
            final BigDecimal aBasePrice,
            final BigDecimal aTotalPrice,
            final String aSize,
            final String aUrl
    ) {
        final var anId = EntryID.unique();
        return new Entry(anId, aProductCode, aProductName, aQuantity, aBasePrice, aTotalPrice, aSize, aUrl);
    }

    @Override
    public void validate(final ValidationHandler handler) {

    }

    public EntryID getId() {
        return id;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public String getSize() {
        return size;
    }

    public String getUrl() {
        return url;
    }
}
