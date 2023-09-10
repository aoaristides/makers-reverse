package br.com.makersweb.reverse.consumer.application.reverse.retrieve.get;

import br.com.makersweb.reverse.consumer.domain.exceptions.NotFoundException;
import br.com.makersweb.reverse.consumer.domain.reverse.Reverse;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseGateway;
import br.com.makersweb.reverse.consumer.domain.reverse.ReverseID;

import java.util.Objects;

/**
 * @author aaristides
 */
public class DefaultGetReverseByIdUseCase extends GetReverseByIdUseCase {

    private final ReverseGateway reverseGateway;

    public DefaultGetReverseByIdUseCase(final ReverseGateway reverseGateway) {
        this.reverseGateway = Objects.requireNonNull(reverseGateway);
    }

    @Override
    public ReverseOutput execute(final String anID) {
        final var aReverseID = ReverseID.from(anID);
        return this.reverseGateway.findById(aReverseID)
                .map(ReverseOutput::from)
                .orElseThrow(() -> NotFoundException.with(Reverse.class, aReverseID));
    }
}
