package br.com.makersweb.reverse.consumer.domain.customer;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class CustomerID extends Identifier {

    private final String value;

    private CustomerID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CustomerID unique() {
        return CustomerID.from(UUID.randomUUID());
    }

    public static CustomerID from(final String anId) {
        return new CustomerID(anId);
    }

    public static CustomerID from(final UUID anId) {
        return new CustomerID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CustomerID that = (CustomerID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

}
