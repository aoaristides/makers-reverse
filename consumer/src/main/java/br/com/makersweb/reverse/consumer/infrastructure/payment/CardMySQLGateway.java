package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.card.Card;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardGateway;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.card.CardRepository;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
public class CardMySQLGateway implements CardGateway {

    private final CardRepository repository;

    public CardMySQLGateway(final CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Card create(final Card aCard) {
        return null;
    }
}
