package br.com.makersweb.reverse.consumer.application.reverse.create;

import br.com.makersweb.reverse.consumer.domain.address.AddressID;
import br.com.makersweb.reverse.consumer.domain.customer.CustomerID;
import br.com.makersweb.reverse.consumer.domain.entries.EntryID;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentID;
import br.com.makersweb.reverse.consumer.domain.reverse.Reverse;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseGateway;

import java.util.List;
import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultCreateReverseUseCase extends CreateReverseUseCase {

    private final ReverseGateway reverseGateway;

    public DefaultCreateReverseUseCase(final ReverseGateway reverseGateway) {
        this.reverseGateway = Objects.requireNonNull(reverseGateway);
    }

    @Override
    public CreateReverseOutput execute(final CreateReverseCommand aCommand) {
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
                                                toEntryID(entries),
                                                PaymentID.from(payment)
                                        );

        return CreateReverseOutput.from(this.reverseGateway.create(aReverse));
    }

    private List<EntryID> toEntryID(final List<String> entries) {
        return entries.stream().map(EntryID::from).toList();
    }
}
