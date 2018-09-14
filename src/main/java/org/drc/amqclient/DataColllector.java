package org.drc.amqclient;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataColllector implements Runnable
{

    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    
    private final Logger LOG = LogManager.getLogger();
    
    public void addElement(final String item)
    {
        LOG.info("Adding : " + item);
        queue.add(item);
    }

    @Override
    public void run()
    {

        while ( true )
        {
            LOG.info("Starting Collection");
            String s;
            while  ( ( s =  queue.poll() )  != null )
            {
                LOG.info(s);
            }
            LOG.info("End Collection");
            try
            {
                Thread.sleep(60000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
