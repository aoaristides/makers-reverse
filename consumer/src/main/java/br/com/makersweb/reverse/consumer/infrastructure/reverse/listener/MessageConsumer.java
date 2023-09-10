package br.com.makersweb.reverse.consumer.infrastructure.reverse.listener;

import br.com.makersweb.reverse.consumer.infrastructure.reverse.models.ReverseRequest;
import io.awspring.cloud.messaging.config.annotation.NotificationMessage;

/**
 * @author aaristides
 */
public interface MessageConsumer {

    void consume(@NotificationMessage ReverseRequest input);

}
