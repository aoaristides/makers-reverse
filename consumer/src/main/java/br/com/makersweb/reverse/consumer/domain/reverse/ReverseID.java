package br.com.makersweb.reverse.consumer.domain.reverse;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class ReverseID extends Identifier {

    private final String value;

    private ReverseID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static ReverseID unique() {
        return ReverseID.from(UUID.randomUUID());
    }

    public static ReverseID from(final String anId) {
        return new ReverseID(anId);
    }

    public static ReverseID from(final UUID anId) {
        return new ReverseID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ReverseID that = (ReverseID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

}
