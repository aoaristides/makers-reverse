package br.com.makersweb.reverse.consumer.application.customer.create;

import java.time.LocalDate;

/**
 * @author aaristides
 * @param name
 * @param document
 * @param phone
 * @param mail
 * @param birthday
 */
public record CreateCustomerCommand(
        String name,
        String document,
        String phone,
        String mail,
        LocalDate birthday
) {

    public static CreateCustomerCommand with(
            final String aName,
            final String aDocument,
            final String aPhone,
            final String aMail,
            final LocalDate aBirthDay
    ) {
        return new CreateCustomerCommand(aName, aDocument, aPhone, aMail, aBirthDay);
    }

}
