package br.com.makersweb.reverse.consumer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
@EnableConfigurationProperties
public class ParameterStoreConfiguration {

    @Value("${credentials.access-key}")
    private String accessKey;

    @Value("${credentials.secret-key}")
    private String secretKey;

    @Value("${credentials.endpoint}")
    private String endpoint;

    @Value("${credentials.region.static}")
    private String region;

    @Value("${receive.reverse.notification.topic.name}")
    private String receiveReverseNotificationTopicName;

    @Value("${receive.reverse.order.queue.name}")
    private String receiveReverseOrderQueueName;

    @Value("${reverse.by.billet.queue.name}")
    private String reverseByBilletQueueName;

    @Value("${reverse.by.credit-card.queue.name}")
    private String reverseByCreditCardQueueName;

    @Value("${reverse.by.debit-card.queue.name}")
    private String reverseByDebitCardQueueName;

    @Value("${reverse.by.pix.queue.name}")
    private String reverseByPixQueueName;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getReceiveReverseNotificationTopicName() {
        return receiveReverseNotificationTopicName;
    }

    public void setReceiveReverseNotificationTopicName(String receiveReverseNotificationTopicName) {
        this.receiveReverseNotificationTopicName = receiveReverseNotificationTopicName;
    }

    public String getReceiveReverseOrderQueueName() {
        return receiveReverseOrderQueueName;
    }

    public void setReceiveReverseOrderQueueName(String receiveReverseOrderQueueName) {
        this.receiveReverseOrderQueueName = receiveReverseOrderQueueName;
    }

    public String getReverseByBilletQueueName() {
        return reverseByBilletQueueName;
    }

    public void setReverseByBilletQueueName(String reverseByBilletQueueName) {
        this.reverseByBilletQueueName = reverseByBilletQueueName;
    }

    public String getReverseByCreditCardQueueName() {
        return reverseByCreditCardQueueName;
    }

    public void setReverseByCreditCardQueueName(String reverseByCreditCardQueueName) {
        this.reverseByCreditCardQueueName = reverseByCreditCardQueueName;
    }

    public String getReverseByDebitCardQueueName() {
        return reverseByDebitCardQueueName;
    }

    public void setReverseByDebitCardQueueName(String reverseByDebitCardQueueName) {
        this.reverseByDebitCardQueueName = reverseByDebitCardQueueName;
    }

    public String getReverseByPixQueueName() {
        return reverseByPixQueueName;
    }

    public void setReverseByPixQueueName(String reverseByPixQueueName) {
        this.reverseByPixQueueName = reverseByPixQueueName;
    }
}
