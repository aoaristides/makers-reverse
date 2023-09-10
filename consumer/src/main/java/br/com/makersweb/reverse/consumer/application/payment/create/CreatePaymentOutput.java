package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.Payment;

/**
 * @author aaristides
 * @param id
 */
public record CreatePaymentOutput(
        String id
) {

    public static CreatePaymentOutput from(final String anId) {
        return new CreatePaymentOutput(anId);
    }

    public static CreatePaymentOutput from(final Payment aPayment) {
        return new CreatePaymentOutput(aPayment.getId().getValue());
    }

}
