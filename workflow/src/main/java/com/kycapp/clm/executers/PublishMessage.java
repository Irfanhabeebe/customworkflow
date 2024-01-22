package com.kycapp.clm.executers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PublishMessage {
     private static final Logger logger =LogManager.getLogger();
    public void run( ){
        logger.info("Inside Publish message" );
    }
}
