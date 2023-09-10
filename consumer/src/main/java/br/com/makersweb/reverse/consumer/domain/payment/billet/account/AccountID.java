package br.com.makersweb.reverse.consumer.domain.payment.billet.account;

import br.com.makersweb.reverse.consumer.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * @author aaristides
 */
public class AccountID extends Identifier {

    private final String value;

    private AccountID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static AccountID unique() {
        return AccountID.from(UUID.randomUUID());
    }

    public static AccountID from(final String anId) {
        return new AccountID(anId);
    }

    public static AccountID from(final UUID anId) {
        return new AccountID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AccountID that = (AccountID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
