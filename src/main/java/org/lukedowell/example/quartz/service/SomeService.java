package org.lukedowell.example.quartz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by ldowell on 2/11/16.
 */
@Service
public class SomeService {

    private Logger logger = LoggerFactory.getLogger(SomeService.class);

    public void printSomething(String something) {
        logger.info("SomeService -- Thread: {} -- Printing Something: {}", Thread.currentThread().getId(), something);
    }
}
