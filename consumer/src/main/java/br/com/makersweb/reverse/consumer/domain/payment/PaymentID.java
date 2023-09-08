package br.com.makersweb.reverse.consumer.domain.payment;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class PaymentID extends Identifier {

    private final String value;

    public PaymentID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static PaymentID unique() {
        return PaymentID.from(UUID.randomUUID());
    }

    public static PaymentID from(final String anId) {
        return new PaymentID(anId);
    }

    public static PaymentID from(final UUID anId) {
        return new PaymentID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PaymentID that = (PaymentID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

}
