package com.dy.ssm.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author daiyun
 * @date 2018-7-4
 */
@Service
public class SecurityHandler {

    private final Logger logger =  LoggerFactory.getLogger(SecurityHandler.class);

    public void checkSecurity(){
        logger.info("aspect SecurityHandler - method checkSecurity");
    }
}
