package br.com.makersweb.reverse.consumer.domain.payment.billet;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountID;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

import java.time.LocalDate;

/**
 * @author aaristides
 */
public class Billet extends AggregateRoot<BilletID> {

    private LocalDate expirationDate;
    private Integer daysToExpire;
    private String link;
    private String barCode;
    private AccountID account;

    private Billet(
            final BilletID anId,
            final LocalDate aExpirationDate,
            final Integer aDaysToExpire,
            final String aLink,
            final String aBarCode,
            final AccountID aAccount
    ) {
        super(anId);
        this.expirationDate = aExpirationDate;
        this.daysToExpire = aDaysToExpire;
        this.link = aLink;
        this.barCode = aBarCode;
        this.account = aAccount;
    }

    public static Billet newBillet(
            final LocalDate aExpirationDate,
            final Integer aDaysToExpire,
            final String aLink,
            final String aBarCode,
            final AccountID aAccount
    ) {
        final var anId = BilletID.unique();
        return new Billet(anId, aExpirationDate, aDaysToExpire, aLink, aBarCode, aAccount);
    }

    public static Billet with(
            final BilletID anId,
            final LocalDate aExpirationDate,
            final Integer aDaysToExpire,
            final String aLink,
            final String aBarCode,
            final AccountID aAccount
    ) {
        return new Billet(anId, aExpirationDate, aDaysToExpire, aLink, aBarCode, aAccount);
    }

    public static Billet with(final Billet aBillet) {
        return with(
                aBillet.getId(),
                aBillet.expirationDate,
                aBillet.daysToExpire,
                aBillet.link,
                aBillet.barCode,
                aBillet.account
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {

    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Integer getDaysToExpire() {
        return daysToExpire;
    }

    public String getLink() {
        return link;
    }

    public String getBarCode() {
        return barCode;
    }

    public AccountID getAccount() {
        return account;
    }
}
