package br.com.makersweb.reverse.consumer.domain.payment;

/**
 * @author aaristides
 */
public interface PaymentGateway {

    Payment create(final Payment aPayment);

}
