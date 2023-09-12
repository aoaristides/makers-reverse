package br.com.makersweb.reverse.consumer.application.payment.create;

import br.com.makersweb.reverse.consumer.domain.payment.billet.Billet;
import br.com.makersweb.reverse.consumer.domain.payment.billet.BilletGateway;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.Account;
import br.com.makersweb.reverse.consumer.domain.payment.billet.account.AccountGateway;
import br.com.makersweb.reverse.consumer.domain.validation.handler.Notification;

/**
 * @author aaristides
 */
public class DefaultCreateBilletUseCase extends CreateBilletUseCase {

    private final BilletGateway billetGateway;
    private final AccountGateway accountGateway;

    public DefaultCreateBilletUseCase(
            final BilletGateway billetGateway,
            final AccountGateway accountGateway
    ) {
        this.billetGateway = billetGateway;
        this.accountGateway = accountGateway;
    }

    @Override
    public CreateBilletOutput execute(final CreateBilletCommand aCommand) {
        final var notification = Notification.create();

        final var aAccountCommand = aCommand.account();
        final var newAccount = Account.newAccount(
                aAccountCommand.name(),
                aAccountCommand.type(),
                aAccountCommand.agency(),
                aAccountCommand.accountNumber(),
                aAccountCommand.bankNumber(),
                aAccountCommand.document()
        );
        final var aAccount = this.accountGateway.create(newAccount);

        final var aBillet = Billet.newBillet(
          aCommand.expirationDate(),
          aCommand.daysToExpire(),
                aCommand.link(),
                aCommand.barCode(),
                aAccount.getId()
        );
        aBillet.validate(notification);

        return CreateBilletOutput.from(this.billetGateway.create(aBillet));
    }
}
