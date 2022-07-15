package com.example.Restful;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController

public class Controller {
    @Value("${var1}")
    public String var1;

    @Value("${var2}")
    public String var2;

    @Value("${url}")
    public String url;

    @Value("${password}")
    public String password;

    @GetMapping("/ping")
    public String getPong(){
        return "pong";
    }

    @GetMapping("/parametros")
    public String getUrlPass(){
        return "Url: " + url + " Password: " + password;
    }

    @GetMapping("/miconfiguracion")
    public String getMiConfig(){
        return var1 + var2;
    }

    @PostConstruct
    public void callAll(){
        System.out.println("Aqui van todas las variables: " + var1 + " " + var2 + " " + url + " " + password);
    }

}
