package br.com.makersweb.reverse.consumer.application.reverse.create;

import br.com.makersweb.reverse.consumer.domain.reverse.Reverse;

/**
 * @author aaristides
 * @param id
 */
public record CreateReverseOutput(
        String id
) {

    public static CreateReverseOutput from(final String anId) {
        return new CreateReverseOutput(anId);
    }

    public static CreateReverseOutput from(final Reverse aReverse) {
        return new CreateReverseOutput(aReverse.getId().getValue());
    }

}
