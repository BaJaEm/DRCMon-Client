package org.drc.amqclient;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DRCClientServices
{

    @Bean
    public DataColllector thingy()
    {
        final DataColllector dc = new DataColllector();
        final Thread t = new Thread(dc);
        t.start();
        return dc;

    }
}
