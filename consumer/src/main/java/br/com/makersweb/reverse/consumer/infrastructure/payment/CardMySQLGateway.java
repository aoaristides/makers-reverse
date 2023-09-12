package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.card.Card;
import br.com.makersweb.reverse.consumer.domain.payment.card.CardGateway;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.card.CardJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.card.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class CardMySQLGateway implements CardGateway {

    private final CardRepository repository;

    public CardMySQLGateway(final CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Card create(final Card aCard) {
        log.info("Init method create card by id - {}", aCard.getId().getValue());
        return save(aCard);
    }

    private Card save(final Card aCard) {
        return this.repository.save(CardJpaEntity.from(aCard)).toAggregate();
    }
}
