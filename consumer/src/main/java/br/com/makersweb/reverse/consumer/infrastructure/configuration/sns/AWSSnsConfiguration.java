package br.com.makersweb.reverse.consumer.infrastructure.configuration.sns;

import br.com.makersweb.reverse.consumer.infrastructure.configuration.ParameterStoreConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * @author aaristides
 */
@Configuration
public class AWSSnsConfiguration {

    private ParameterStoreConfiguration configuration;
    private AWSCredentialsProvider credentialsProvider;
    private ObjectMapper mapper;

    public AWSSnsConfiguration(
            @Autowired ParameterStoreConfiguration configuration,
            @Autowired AWSCredentialsProvider credentialsProvider,
            @Autowired ObjectMapper mapper
    ) {
        this.configuration = configuration;
        this.credentialsProvider = credentialsProvider;
        this.mapper = mapper;
    }

    @Bean
    @Primary
    public AmazonSNS amazonSNS(final AwsClientBuilder.EndpointConfiguration endpointConfiguration) {
        return AmazonSNSClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(credentialsProvider)
                .build();
    }

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate(AmazonSNS amazonSNS) {
        NotificationMessagingTemplate notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSNS);
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setSerializedPayloadClass(String.class);
        mapper.registerModule(new JavaTimeModule());
        mappingJackson2MessageConverter.setObjectMapper(mapper);
        notificationMessagingTemplate.setMessageConverter(mappingJackson2MessageConverter);
        notificationMessagingTemplate.setDefaultDestinationName(configuration.getReceiveReverseNotificationTopicName());
        return notificationMessagingTemplate;
    }

}
