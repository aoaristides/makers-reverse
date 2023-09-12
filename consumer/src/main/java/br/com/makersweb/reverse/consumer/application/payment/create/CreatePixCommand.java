package br.com.makersweb.reverse.consumer.application.payment.create;

/**
 * @author aaristides
 * @param pspReferenceId
 * @param referenceId
 * @param message
 */
public record CreatePixCommand(
        String pspReferenceId,
        String referenceId,
        String message
) {

    public static CreatePixCommand with(
            final String aPspReferenceId,
            final String aReferenceId,
            final String aMessage
    ) {
        return new CreatePixCommand(aPspReferenceId, aReferenceId, aMessage);
    }

}
