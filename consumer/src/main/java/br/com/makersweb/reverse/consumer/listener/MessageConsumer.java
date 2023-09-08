package br.com.makersweb.reverse.consumer.listener;

import br.com.makersweb.reverse.consumer.domain.dto.Event;
import io.awspring.cloud.messaging.config.annotation.NotificationMessage;

/**
 * @author aaristides
 */
public interface MessageConsumer {

    void consume(@NotificationMessage Event event);

}
