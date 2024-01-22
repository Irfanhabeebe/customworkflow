package com.kycapp.clm.executers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RetreiveData {

    private static final Logger logger =LogManager.getLogger();
    public void run( ){
        logger.info("Inside Retreive data" );
    }
}
