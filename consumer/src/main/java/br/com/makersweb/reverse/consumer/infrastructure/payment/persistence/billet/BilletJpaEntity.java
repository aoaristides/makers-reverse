package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet;

import br.com.makersweb.reverse.consumer.domain.payment.billet.Billet;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletID;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountID;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.billet.account.AccountJpaEntity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author aaristides
 */
@Entity(name = "Billet")
@Table(name = "billet")
public class BilletJpaEntity {

    @Id
    private String id;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "days_to_expire")
    private Integer daysToExpire;

    @Column(name = "link")
    private String link;

    @Column(name = "bar_code")
    private String barCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private AccountJpaEntity account;

    public BilletJpaEntity() {}

    private BilletJpaEntity(
            final String id,
            final LocalDate expirationDate,
            final Integer daysToExpire,
            final String link,
            final String barCode,
            final AccountJpaEntity account
    ) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.daysToExpire = daysToExpire;
        this.link = link;
        this.barCode = barCode;
        this.account = account;
    }

    private BilletJpaEntity(final BilletID anId) {
        this.id = anId.getValue();
    }

    public static BilletJpaEntity from(final BilletID anId) {
        return new BilletJpaEntity(anId);
    }

    public static BilletJpaEntity from(final Billet aBillet) {
        return new BilletJpaEntity(
                aBillet.getId().getValue(),
                aBillet.getExpirationDate(),
                aBillet.getDaysToExpire(),
                aBillet.getLink(),
                aBillet.getBarCode(),
                AccountJpaEntity.from(aBillet.getAccount())
        );
    }

    public Billet toAggregate() {
        return Billet.with(
                BilletID.from(getId()),
                getExpirationDate(),
                getDaysToExpire(),
                getLink(),
                getBarCode(),
                getAccountID()
        );
    }

    private AccountID getAccountID() {
        return AccountID.from(getAccount().getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(Integer daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public AccountJpaEntity getAccount() {
        return account;
    }

    public void setAccount(AccountJpaEntity account) {
        this.account = account;
    }
}
