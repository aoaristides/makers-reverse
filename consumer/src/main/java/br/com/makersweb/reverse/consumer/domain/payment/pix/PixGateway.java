package br.com.makersweb.reverse.consumer.domain.payment.pix;

/**
 * @author aaristides
 */
public interface PixGateway {

    Pix create(final Pix aPix);

}
