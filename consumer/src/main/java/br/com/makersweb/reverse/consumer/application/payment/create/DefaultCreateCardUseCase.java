package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.card.Card;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardGateway;
import br.com.makersweb.reverse.consumer.domain.validation.handler.Notification;

/**
 * @author aaristides
 */
public class DefaultCreateCardUseCase extends CreateCardUseCase {

    private final CardGateway cardGateway;

    public DefaultCreateCardUseCase(final CardGateway cardGateway) {
        this.cardGateway = cardGateway;
    }

    @Override
    public CreateCardOutput execute(final CreateCardCommand aCommand) {
        final var notification = Notification.create();

        final var aCard = Card.newCard(
                aCommand.cardNumber(),
                aCommand.holder(),
                aCommand.brand(),
                aCommand.expirationDate(),
                aCommand.securityCode(),
                aCommand.cardToken(),
                aCommand.installments(),
                aCommand.isSaveCard()
        );
        aCard.validate(notification);

        return CreateCardOutput.from(this.cardGateway.create(aCard));
    }
}
