package br.com.makersweb.reverse.consumer.infrastructure.api.controllers;

import br.com.makersweb.reverse.consumer.application.address.create.CreateAddressCommand;
import br.com.makersweb.reverse.consumer.application.address.create.CreateAddressUseCase;
import br.com.makersweb.reverse.consumer.application.customer.create.CreateCustomerCommand;
import br.com.makersweb.reverse.consumer.application.customer.create.CreateCustomerUseCase;
import br.com.makersweb.reverse.consumer.application.entries.create.CreateEntryCommand;
import br.com.makersweb.reverse.consumer.application.entries.create.CreateEntryOutput;
import br.com.makersweb.reverse.consumer.application.entries.create.CreateEntryUseCase;
import br.com.makersweb.reverse.consumer.application.payment.create.*;
import br.com.makersweb.reverse.consumer.application.reverse.create.CreateReverseCommand;
import br.com.makersweb.reverse.consumer.application.reverse.create.CreateReverseOutput;
import br.com.makersweb.reverse.consumer.application.reverse.create.CreateReverseUseCase;
import br.com.makersweb.reverse.consumer.application.reverse.retrieve.get.GetReverseByIdUseCase;
import br.com.makersweb.reverse.consumer.domain.validation.handler.Notification;
import br.com.makersweb.reverse.consumer.infrastructure.api.ReverseAPI;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.models.ReverseRequest;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.models.ReverseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author aaristides
 */
@RestController
public class ReverseController implements ReverseAPI {

    private final CreateReverseUseCase createReverseUseCase;
    private final GetReverseByIdUseCase getReverseByIdUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CreateAddressUseCase createAddressUseCase;
    private final CreatePaymentUseCase createPaymentUseCase;
    private final CreateEntryUseCase createEntryUseCase;
    private final CreateCardUseCase createCardUseCase;
    private final CreateBilletUseCase createBilletUseCase;
    private final CreatePixUseCase createPixUseCase;

    public ReverseController(
            final CreateReverseUseCase createReverseUseCase,
            final GetReverseByIdUseCase getReverseByIdUseCase,
            final CreateCustomerUseCase createCustomerUseCase,
            final CreateAddressUseCase createAddressUseCase,
            final CreatePaymentUseCase createPaymentUseCase,
            final CreateEntryUseCase createEntryUseCase,
            final CreateCardUseCase createCardUseCase,
            final CreateBilletUseCase createBilletUseCase,
            final CreatePixUseCase createPixUseCase) {
        this.createReverseUseCase = Objects.requireNonNull(createReverseUseCase);
        this.getReverseByIdUseCase = Objects.requireNonNull(getReverseByIdUseCase);
        this.createCustomerUseCase = Objects.requireNonNull(createCustomerUseCase);
        this.createAddressUseCase = Objects.requireNonNull(createAddressUseCase);
        this.createPaymentUseCase = Objects.requireNonNull(createPaymentUseCase);
        this.createEntryUseCase = Objects.requireNonNull(createEntryUseCase);
        this.createCardUseCase = Objects.requireNonNull(createCardUseCase);
        this.createBilletUseCase = Objects.requireNonNull(createBilletUseCase);
        this.createPixUseCase = Objects.requireNonNull(createPixUseCase);
    }

    @Override
    public ResponseEntity<?> createReverse(final ReverseRequest input) {
        final var inCustomer = input.customer();
        final var aCustomerCommand = CreateCustomerCommand.with(
                inCustomer.name(),
                inCustomer.document(),
                inCustomer.phone(),
                inCustomer.mail(),
                inCustomer.birthday()
        );
        final var aCustomerOutput = this.createCustomerUseCase.execute(aCustomerCommand);

        final var inAddress = input.deliveryAddress();
        final var aAddressCommand = CreateAddressCommand.with(
                inAddress.streetName(),
                inAddress.streetNumber(),
                inAddress.city(),
                inAddress.district(),
                inAddress.complement(),
                inAddress.postalCode()
        );
        final var aAddressOutput = this.createAddressUseCase.execute(aAddressCommand);

        final var aEntries = this.createEntryUseCase.execute(addEntryCommand(input))
                .stream()
                .map(CreateEntryOutput::id).toList();

        final var inPayment = input.payment();
        final var inCard = inPayment.card();
        final var inBillet = inPayment.billet();
        final var inPix = inPayment.pix();
        final var inAccount = Objects.nonNull(inBillet) ? inBillet.account() : null;
        CreateCardOutput aCardOutput = null;
        if (Objects.nonNull(inCard)) {
            final var aCardCommand = CreateCardCommand.with(
                    inCard.cardNumber(),
                    inCard.holder(),
                    inCard.brand(),
                    inCard.expirationDate(),
                    inCard.securityCode(),
                    inCard.cardToken(),
                    inCard.installments(),
                    inCard.saveCard()
            );
            aCardOutput = this.createCardUseCase.execute(aCardCommand);
        }

        CreateBilletOutput aBilletOutput = null;
        if (Objects.nonNull(inBillet)) {
            final var aBilletCommand = CreateBilletCommand.with(
                    inBillet.expirationDate(),
                    inBillet.daysToExpire(),
                    inBillet.link(),
                    inBillet.barCode(),
                    CreateAccountCommand.with(
                            inAccount.name(),
                            inAccount.type(),
                            inAccount.agency(),
                            inAccount.accountNumber(),
                            inAccount.bankNumber(),
                            inAccount.document()
                    )
            );
            aBilletOutput = this.createBilletUseCase.execute(aBilletCommand);
        }

        CreatePixOutput aPixOutput = null;
        if (Objects.nonNull(inPix)) {
            final var aPixCommand = CreatePixCommand.with(
                    inPix.pspReferenceId(),
                    inPix.referenceId(),
                    inPix.message()
            );
            aPixOutput = this.createPixUseCase.execute(aPixCommand);
        }

        final var aPaymentCommand = CreatePaymentCommand.with(
                inPayment.type(),
                inPayment.amount(),
                Objects.nonNull(aCardOutput) ? aCardOutput.id() : null,
                Objects.nonNull(aBilletOutput) ? aBilletOutput.id() : null,
                Objects.nonNull(aPixOutput) ? aPixOutput.id() : null
        );
        final var aPaymentOutput = this.createPaymentUseCase.execute(aPaymentCommand);

        final var aReverseCommand = CreateReverseCommand.with(
                input.originalOrder(),
                input.reverseOrder(),
                input.type(),
                input.createdOrder(),
                input.createdReverse(),
                input.deliveryCost(),
                input.discount(),
                input.totalValue(),
                input.estimatedDeliveryTime(),
                input.deliveryDate(),
                input.deliveryMode(),
                aCustomerOutput.id(),
                aAddressOutput.id(),
                aEntries,
                aPaymentOutput.id()
        );

        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateReverseOutput, ResponseEntity<?>> onSuccess = output ->
                ResponseEntity.created(URI.create("/reverses/" + output.id())).body(output);

        ResponseEntity<?> fold = this.createReverseUseCase.execute(aReverseCommand)
                .fold(onError, onSuccess);
        return fold;
    }

    @Override
    public ReverseResponse getById(final String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateById(final String id, ReverseRequest input) {
        return null;
    }

    @Override
    public void deleteById(final String id) {

    }

    private List<CreateEntryCommand> addEntryCommand(final ReverseRequest input) {
        List<CreateEntryCommand> aEntryCommands = new ArrayList<>();
        input.entries().forEach(entry -> {
            aEntryCommands.add(
                    CreateEntryCommand
                            .with(
                                    entry.productCode(),
                                    entry.productName(),
                                    entry.quantity(),
                                    entry.basePrice(),
                                    entry.totalPrice(),
                                    entry.size(),
                                    entry.url()
                            )
            );
        });

        return aEntryCommands;
    }
}
