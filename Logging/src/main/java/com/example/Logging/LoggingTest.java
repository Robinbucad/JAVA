package com.example.Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingTest {

    Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    @RequestMapping("/log")
    public String getError(){
        logger.error("Hola soy un log de error");
        return "Hola log error";
    }

    @RequestMapping("/warn")
    public String getWarn(){
        logger.warn("Hola soy un warn, no me guardaré en el file error, saldré por consola");
        return "Hola soy un warn";
    }

}
