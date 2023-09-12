package br.com.makersweb.reverse.consumer.application.payment.create;

import java.time.LocalDate;

/**
 * @author aaristides
 * @param expirationDate
 * @param daysToExpire
 * @param link
 * @param barCode
 * @param account
 */
public record CreateBilletCommand(
        LocalDate expirationDate,
        Integer daysToExpire,
        String link,
        String barCode,
        CreateAccountCommand account
) {

    public static CreateBilletCommand with(
            final LocalDate aExpirationDate,
            final Integer aDaysToExpire,
            final String aLink,
            final String aBarCode,
            final CreateAccountCommand aAccount
    ) {
        return new CreateBilletCommand(aExpirationDate, aDaysToExpire, aLink, aBarCode, aAccount);
    }

}
