package br.com.makersweb.reverse.consumer.domain.payment.billet;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class BilletID extends Identifier {

    private final String value;

    private BilletID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static BilletID unique() {
        return BilletID.from(UUID.randomUUID());
    }

    public static BilletID from(final String anId) {
        return new BilletID(anId);
    }

    public static BilletID from(final UUID anId) {
        return new BilletID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BilletID that = (BilletID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
