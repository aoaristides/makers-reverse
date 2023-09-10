package br.com.makersweb.reverse.consumer.domain.payment.pix;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class PixID extends Identifier {

    private final String value;

    private PixID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static PixID unique() {
        return PixID.from(UUID.randomUUID());
    }

    public static PixID from(final String anId) {
        return new PixID(anId);
    }

    public static PixID from(final UUID anId) {
        return new PixID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PixID that = (PixID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
