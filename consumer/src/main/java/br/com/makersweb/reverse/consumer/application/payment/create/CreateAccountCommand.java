package br.com.makersweb.reverse.consumer.application.payment.create;

/**
 * @author aaristides
 * @param name
 * @param type
 * @param agency
 * @param accountNumber
 * @param bankNumber
 * @param document
 * @author aaristides
 */
public record CreateAccountCommand(
        String name,
        String type,
        String agency,
        String accountNumber,
        String bankNumber,
        String document
) {

    public static CreateAccountCommand with(
            final String aName,
            final String aType,
            final String aAgency,
            final String aAccountNumber,
            final String aBankNumber,
            final String aDocument
    ) {
        return new CreateAccountCommand(aName, aType, aAgency, aAccountNumber, aBankNumber, aDocument);
    }

}
