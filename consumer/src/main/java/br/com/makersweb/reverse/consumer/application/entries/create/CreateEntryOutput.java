package br.com.makersweb.reverse.consumer.application.entries.create;

import br.com.makersweb.reverse.consumer.domain.entries.Entry;

/**
 * @author aaristides
 * @param id
 */
public record CreateEntryOutput(
        String id
) {

    public static CreateEntryOutput from(final String anId) {
        return new CreateEntryOutput(anId);
    }

    public static CreateEntryOutput from(final Entry aEntry) {
        return new CreateEntryOutput(aEntry.getId().getValue());
    }

}
