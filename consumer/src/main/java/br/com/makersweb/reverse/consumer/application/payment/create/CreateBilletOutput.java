package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.billet.Billet;

/**
 * @author aaristides
 * @param id
 */
public record CreateBilletOutput(
        String id
) {

    public static CreateBilletOutput from(final String anId) {
        return new CreateBilletOutput(anId);
    }

    public static CreateBilletOutput from(final Billet aBillet) {
        return new CreateBilletOutput(aBillet.getId().getValue());
    }

}
