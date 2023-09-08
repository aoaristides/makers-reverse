package br.com.makersweb.reverse.consumer.domain.payment;

import br.com.makersweb.reverse.consumer.domain.ValueObject;

/**
 * @author aaristides
 */
public class Pix extends ValueObject {

    private String pspReferenceId;
    private String referenceId;
    private String message;

    private Pix(
            final String aPspReferenceId,
            final String aReferenceId,
            final String aMessage
    ) {
        this.pspReferenceId = aPspReferenceId;
        this.referenceId = aReferenceId;
        this.message = aMessage;
    }

    public static Pix newPix(
            final String aPspReferenceId,
            final String aReferenceId,
            final String aMessage
    ) {
        return new Pix(aPspReferenceId, aReferenceId, aMessage);
    }

    public String getPspReferenceId() {
        return pspReferenceId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public String getMessage() {
        return message;
    }
}
