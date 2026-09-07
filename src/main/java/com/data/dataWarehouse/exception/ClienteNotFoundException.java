package com.data.dataWarehouse.exception;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException(String mensaje) {
        super(mensaje);
    }

}
