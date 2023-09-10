package br.com.makersweb.reverse.consumer.domain.payment.card;

/**
 * @author aaristides
 */
public interface CardGateway {

    Card create(final Card aCard);

}
