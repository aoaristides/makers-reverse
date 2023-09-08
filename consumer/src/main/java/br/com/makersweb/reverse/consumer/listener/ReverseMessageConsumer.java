package br.com.makersweb.reverse.consumer.listener;

import br.com.makersweb.reverse.consumer.domain.dto.Event;
import io.awspring.cloud.messaging.config.annotation.NotificationMessage;
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
    public void consume(@NotificationMessage final Event event) {
        if (event != null) {
            log.info("Receiver reverse success.");
        }
    }
}
