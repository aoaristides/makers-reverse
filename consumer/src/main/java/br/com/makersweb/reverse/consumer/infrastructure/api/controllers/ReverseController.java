package br.com.makersweb.reverse.consumer.infrastructure.api.controllers;

import br.com.makersweb.reverse.consumer.application.address.create.CreateAddressCommand;
import br.com.makersweb.reverse.consumer.application.address.create.CreateAddressUseCase;
import br.com.makersweb.reverse.consumer.application.customer.create.CreateCustomerCommand;
import br.com.makersweb.reverse.consumer.application.customer.create.CreateCustomerUseCase;
import br.com.makersweb.reverse.consumer.application.payment.create.CreatePaymentUseCase;
import br.com.makersweb.reverse.consumer.application.reverse.create.CreateReverseCommand;
import br.com.makersweb.reverse.consumer.application.reverse.create.CreateReverseUseCase;
import br.com.makersweb.reverse.consumer.application.reverse.retrieve.get.GetReverseByIdUseCase;
import br.com.makersweb.reverse.consumer.infrastructure.api.ReverseAPI;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.models.ReverseRequest;
import br.com.makersweb.reverse.consumer.infrastructure.reverse.models.ReverseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

    public ReverseController(
            final CreateReverseUseCase createReverseUseCase,
            final GetReverseByIdUseCase getReverseByIdUseCase,
            final CreateCustomerUseCase createCustomerUseCase,
            final CreateAddressUseCase createAddressUseCase,
            final CreatePaymentUseCase createPaymentUseCase) {
        this.createReverseUseCase = Objects.requireNonNull(createReverseUseCase);
        this.getReverseByIdUseCase = Objects.requireNonNull(getReverseByIdUseCase);
        this.createCustomerUseCase = Objects.requireNonNull(createCustomerUseCase);
        this.createAddressUseCase = Objects.requireNonNull(createAddressUseCase);
        this.createPaymentUseCase = Objects.requireNonNull(createPaymentUseCase);
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
                null,
                ""
        );
        return null;
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
}
