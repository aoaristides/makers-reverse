package br.com.makersweb.reverse.consumer.domain.payment.card;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class CardID extends Identifier {

    private final String value;

    private CardID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CardID unique() {
        return CardID.from(UUID.randomUUID());
    }

    public static CardID from(final String anId) {
        return new CardID(anId);
    }

    public static CardID from(final UUID anId) {
        return new CardID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CardID that = (CardID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
