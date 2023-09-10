package br.com.makersweb.reverse.consumer.domain.address;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class AddressID extends Identifier {

    private final String value;

    public AddressID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static AddressID unique() {
        return AddressID.from(UUID.randomUUID());
    }

    public static AddressID from(final String anId) {
        return new AddressID(anId);
    }

    public static AddressID from(final UUID anId) {
        return new AddressID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AddressID that = (AddressID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
