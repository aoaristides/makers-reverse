package br.com.makersweb.reverse.consumer.infrastructure.payment;

import br.com.makersweb.reverse.consumer.domain.payment.Payment;
import br.com.makersweb.reverse.consumer.domain.payment.PaymentGateway;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.payment.PaymentJpaEntity;
import br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.payment.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class PaymentMySQLGateway implements PaymentGateway {

    private final PaymentRepository repository;

    public PaymentMySQLGateway(final PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(final Payment aPayment) {
        log.info("Init method create payment by id - {}", aPayment.getId().getValue());
        return save(aPayment);
    }

    private Payment save(final Payment aPayment) {
        return this.repository.save(PaymentJpaEntity.from(aPayment)).toAggregate();
    }
}
