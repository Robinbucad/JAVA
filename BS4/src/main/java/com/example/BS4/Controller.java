package com.example.BS4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${VAR1}")
    private String var1;

    @Value("${VAR2}")
    private String var2;

    @Value("${VAR3: No tiene valor}")
    private String var3;

    @GetMapping("/valores")
    public String getValue(){
        return "Valor de var1 es: " + var1 + " valor de my.var es: " + var2;
    }

    @GetMapping("/var3")
    public String getValue3(){
        return "El valor de var3 es: " + var3;
    }

}
