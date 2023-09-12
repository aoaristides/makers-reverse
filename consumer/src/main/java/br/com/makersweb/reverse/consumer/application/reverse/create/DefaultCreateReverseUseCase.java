package br.com.makersweb.reverse.consumer.application.reverse.create;

import br.com.makersweb.reverse.consumer.domain.address.AddressID;
import br.com.makersweb.reverse.consumer.domain.customer.CustomerID;
import br.com.makersweb.reverse.consumer.domain.entries.Entry;
import br.com.makersweb.reverse.consumer.domain.entries.EntryGateway;
import br.com.makersweb.reverse.consumer.domain.entries.EntryID;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentID;
import br.com.makersweb.reverse.consumer.domain.reverse.Reverse;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseGateway;
import br.com.makersweb.reverse.consumer.domain.validation.handler.Notification;
import io.vavr.control.Either;

import java.util.List;
import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

/**
 * @author aaristides
 */
public class DefaultCreateReverseUseCase extends CreateReverseUseCase {

    private final ReverseGateway reverseGateway;
    private final EntryGateway entryGateway;

    public DefaultCreateReverseUseCase(
            final ReverseGateway reverseGateway,
            final EntryGateway entryGateway
    ) {
        this.reverseGateway = reverseGateway;
        this.entryGateway = entryGateway;
    }

    @Override
    public Either<Notification, CreateReverseOutput> execute(final CreateReverseCommand aCommand) {
        final var originalOrder = aCommand.originalOrder();
        final var reverseOrder = aCommand.reverseOrder();
        final var type = aCommand.type();
        final var createdOrder = aCommand.createdOrder();
        final var createdReverse = aCommand.createdReverse();
        final var deliveryCost = aCommand.deliveryCost();
        final var discount = aCommand.discount();
        final var totalValue = aCommand.totalValue();
        final var estimatedDeliveryTime = aCommand.estimatedDeliveryTime();
        final var deliveryDate = aCommand.deliveryDate();
        final var deliveryMode = aCommand.deliveryMode();
        final var customer = aCommand.customer();
        final var address = aCommand.address();
        final var entries = aCommand.entries();
        final var payment = aCommand.payment();

        final var notification = Notification.create();

        final var aReverse = Reverse.newReverse(
                originalOrder,
                reverseOrder,
                type,
                createdOrder,
                createdReverse,
                deliveryCost,
                discount,
                totalValue,
                estimatedDeliveryTime,
                deliveryDate,
                deliveryMode,
                CustomerID.from(customer),
                AddressID.from(address),
                toEntries(entries),
                PaymentID.from(payment)
        );
        aReverse.validate(notification);

        return notification.hasError() ? Left(notification) : create(aReverse);
    }

    private Either<Notification, CreateReverseOutput> create(final Reverse aReverse) {
        return Try(() -> this.reverseGateway.create(aReverse))
                .toEither()
                .bimap(Notification::create, CreateReverseOutput::from);
    }

    private List<Entry> toEntries(final List<String> entries) {
        return this.entryGateway.findByIds(entries);
    }
}
