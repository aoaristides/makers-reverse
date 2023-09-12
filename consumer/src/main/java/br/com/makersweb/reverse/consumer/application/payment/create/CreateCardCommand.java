package br.com.makersweb.reverse.consumer.application.payment.create;

/**
 * @author aaristides
 * @param cardNumber
 * @param holder
 * @param brand
 * @param expirationDate
 * @param securityCode
 * @param cardToken
 * @param installments
 * @param isSaveCard
 */
public record CreateCardCommand(
        String cardNumber,
        String holder,
        String brand,
        String expirationDate,
        String securityCode,
        String cardToken,
        Integer installments,
        boolean isSaveCard
) {

    public static CreateCardCommand with(
            final String aCardNumber,
            final String aHolder,
            final String aBrand,
            final String aExpirationDate,
            final String aSecurityCode,
            final String aCardToken,
            final Integer aInstallments,
            final boolean isSaveCard
    ) {
        return new CreateCardCommand(aCardNumber, aHolder, aBrand, aExpirationDate, aSecurityCode, aCardToken, aInstallments, isSaveCard);
    }

}
