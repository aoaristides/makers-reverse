package br.com.makersweb.reverse.consumer.domain.payment.pix;

import br.com.makersweb.reverse.consumer.domain.AggregateRoot;
import br.com.makersweb.reverse.consumer.domain.validation.ValidationHandler;

/**
 * @author aaristides
 */
public class Pix extends AggregateRoot<PixID> {

    private String pspReferenceId;
    private String referenceId;
    private String message;

    private Pix(
            final PixID anId,
            final String aPspReferenceId,
            final String aReferenceId,
            final String aMessage
    ) {
        super(anId);
        this.pspReferenceId = aPspReferenceId;
        this.referenceId = aReferenceId;
        this.message = aMessage;
    }

    public static Pix newPix(
            final String aPspReferenceId,
            final String aReferenceId,
            final String aMessage
    ) {
        final var anId = PixID.unique();
        return new Pix(anId, aPspReferenceId, aReferenceId, aMessage);
    }

    public static Pix with(
            final PixID anId,
            final String aPspReferenceId,
            final String aReferenceId,
            final String aMessage
    ) {
        return new Pix(anId, aPspReferenceId, aReferenceId, aMessage);
    }

    public static Pix with(final Pix aPix) {
        return with(aPix.getId(), aPix.pspReferenceId, aPix.referenceId, aPix.message);
    }

    @Override
    public void validate(final ValidationHandler handler) {

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
