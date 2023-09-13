package br.com.makersweb.reverse.consumer.infrastructure.reverse.listener;

import io.awspring.cloud.messaging.config.annotation.NotificationMessage;

/**
 * @author aaristides
 */
public interface MessageConsumer {

    void consume(final String input);

}
