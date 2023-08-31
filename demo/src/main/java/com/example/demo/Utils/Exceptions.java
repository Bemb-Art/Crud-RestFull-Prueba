package com.example.demo.Utils;

import org.springframework.http.HttpStatus;

public class Exceptions extends RuntimeException{
    private String mensaje;
    private HttpStatus httpStatus;

    public Exceptions(String mensaje, HttpStatus httpStatus){
        super(mensaje);
        this.mensaje = mensaje;
        this.httpStatus = httpStatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
