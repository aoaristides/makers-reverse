package br.com.makersweb.reverse.consumer.application.entries.create;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param productCode
 * @param productName
 * @param quantity
 * @param basePrice
 * @param totalPrice
 * @param size
 * @param url
 */
public record CreateEntryCommand(
        String productCode,
        String productName,
        Integer quantity,
        BigDecimal basePrice,
        BigDecimal totalPrice,
        String size,
        String url
) {

    public static CreateEntryCommand with(
            final String aProductCode,
            final String aProductName,
            final Integer aQuantity,
            final BigDecimal aBasePrice,
            final BigDecimal aTotalPrice,
            final String aSize,
            final String aUrl
    ) {
        return new CreateEntryCommand(
                aProductCode,
                aProductName,
                aQuantity,
                aBasePrice,
                aTotalPrice,
                aSize,
                aUrl
        );
    }

}
