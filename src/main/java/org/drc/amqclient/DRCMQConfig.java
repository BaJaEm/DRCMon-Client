package org.drc.amqclient;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class DRCMQConfig
{

    @Bean
    public JmsListenerContainerFactory<?> myFactory(//
            final ConnectionFactory connectionFactory, //
            final DefaultJmsListenerContainerFactoryConfigurer configurer)
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        factory.setClientId("DRCMQ-Client-111");
        factory.setConcurrency("1");

        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
