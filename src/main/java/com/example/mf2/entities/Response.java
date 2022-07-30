package com.example.mf2.entities;

import lombok.Data;

@Data
public class Response {
    private Integer code;
    private String message;
    private Object body;

    public Response(Integer code, String message, Object body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
