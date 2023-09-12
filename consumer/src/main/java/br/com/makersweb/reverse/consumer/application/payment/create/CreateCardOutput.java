package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.card.Card;

/**
 * @author aaristides
 * @param id
 */
public record CreateCardOutput(
        String id
) {

    public static CreateCardOutput from(final String anId) {
        return new CreateCardOutput(anId);
    }

    public static CreateCardOutput from(final Card aCard) {
        return new CreateCardOutput(aCard.getId().getValue());
    }

}
