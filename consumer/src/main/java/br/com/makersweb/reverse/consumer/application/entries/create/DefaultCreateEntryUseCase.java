package br.com.makersweb.reverse.consumer.application.entries.create;

import br.com.makersweb.reverse.consumer.domain.entries.Entry;
import br.com.makersweb.reverse.consumer.domain.entries.EntryGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultCreateEntryUseCase extends CreateEntryUseCase {

    private final EntryGateway entryGateway;

    public DefaultCreateEntryUseCase(final EntryGateway entryGateway) {
        this.entryGateway = Objects.requireNonNull(entryGateway);
    }

    @Override
    public List<CreateEntryOutput> execute(final List<CreateEntryCommand> aCommands) {
        List<CreateEntryOutput> entries = new ArrayList<>();
        aCommands.stream().forEach(aCommand -> {
            final var productCode = aCommand.productCode();
            final var productName = aCommand.productName();
            final var quantity = aCommand.quantity();
            final var basePrice = aCommand.basePrice();
            final var totalPrice = aCommand.totalPrice();
            final var size = aCommand.size();
            final var url = aCommand.url();

            final var entry = Entry.newEntry(productCode, productName, quantity, basePrice, totalPrice, size, url);

            entries.add(CreateEntryOutput.from(this.entryGateway.create(entry)));
        });

        return entries;
    }
}
