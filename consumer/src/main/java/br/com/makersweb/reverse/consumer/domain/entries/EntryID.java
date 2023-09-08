package br.com.makersweb.reverse.consumer.domain.entries;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class EntryID extends Identifier {

    private final String value;

    public EntryID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static EntryID unique() {
        return EntryID.from(UUID.randomUUID());
    }

    public static EntryID from(final String anId) {
        return new EntryID(anId);
    }

    public static EntryID from(final UUID anId) {
        return new EntryID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final EntryID that = (EntryID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
