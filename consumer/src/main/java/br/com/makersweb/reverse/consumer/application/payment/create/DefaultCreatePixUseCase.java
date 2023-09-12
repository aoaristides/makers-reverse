package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.pix.Pix;
import br.com.makersweb.reverse.consumer.domain.payment.pix.PixGateway;
import br.com.makersweb.reverse.consumer.domain.validation.handler.Notification;

/**
 * @author aaristides
 */
public class DefaultCreatePixUseCase extends CreatePixUseCase {

    private final PixGateway pixGateway;

    public DefaultCreatePixUseCase(final PixGateway pixGateway) {
        this.pixGateway = pixGateway;
    }

    @Override
    public CreatePixOutput execute(final CreatePixCommand aCommand) {
        final var notification = Notification.create();

        final var aPix = Pix.newPix(
                aCommand.pspReferenceId(),
                aCommand.referenceId(),
                aCommand.message()
        );
        aPix.validate(notification);

        return CreatePixOutput.from(this.pixGateway.create(aPix));
    }
}
