package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.pix.Pix;

/**
 * @author aaristides
 * @param id
 */
public record CreatePixOutput(
        String id
) {

    public static CreatePixOutput from(final String anId) {
        return new CreatePixOutput(anId);
    }

    public static CreatePixOutput from(final Pix aPix) {
        return new CreatePixOutput(aPix.getId().getValue());
    }

}
