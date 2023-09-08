package br.com.makersweb.reverse.consumer.domain.payment;

import br.com.makersweb.reverse.consumer.domain.ValueObject;

import java.time.LocalDate;

/**
 * @author aaristides
 */
public class Billet extends ValueObject {

    private LocalDate expirationDate;
    private Integer daysToExpire;
    private String link;
    private String barCode;
    private Account account;

    private Billet(
            final LocalDate aExpirationDate,
            final Integer aDaysToExpire,
            final String aLink,
            final String aBarCode,
            final Account aAccount
    ) {
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
            final Account aAccount
    ) {
        return new Billet(aExpirationDate, aDaysToExpire, aLink, aBarCode, aAccount);
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

    public Account getAccount() {
        return account;
    }
}
