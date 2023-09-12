package br.com.makersweb.reverse.consumer.application.payment.create;

import java.math.BigDecimal;

/**
 * @author aaristides
 * @param type
 * @param amount
 * @param card
 * @param billet
 * @param pix
 */
public record CreatePaymentCommand(
        String type,
        BigDecimal amount,
        String card,
        String billet,
        String pix
) {

    public static CreatePaymentCommand with(
            final String aType,
            final BigDecimal aAmount,
            final String aCard,
            final String aBillet,
            final String aPix
    ) {
        return new CreatePaymentCommand(aType, aAmount, aCard, aBillet, aPix);
    }

}