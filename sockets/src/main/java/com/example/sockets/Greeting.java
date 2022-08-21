package com.example.sockets;


import lombok.Data;

@Data
public class Greeting {

    private String content;

    public Greeting(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
    public Greeting(){}

}
