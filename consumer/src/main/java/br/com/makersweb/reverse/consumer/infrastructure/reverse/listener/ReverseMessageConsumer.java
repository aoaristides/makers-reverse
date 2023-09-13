package br.com.makersweb.reverse.consumer.infrastructure.reverse.listener;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aaristides
 */
@Component
@Slf4j
public class ReverseMessageConsumer implements MessageConsumer {

    @Override
    @SqsListener(value = "${receive.reverse.order.queue.name}")
    public void consume(final String input) {
        if (input != null) {
            log.info("Receiver reverse success - {}.", input.toString());
        }
    }
}
