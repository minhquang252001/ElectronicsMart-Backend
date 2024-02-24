package com.example.electrostore.exception;

public class ProductNotfoundException extends RuntimeException{

     private String titlerError;

    public String getTitlerError() {
        return titlerError;
    }

    public void setTitlerError(String titlerError) {
        this.titlerError = titlerError;
    }

    public ProductNotfoundException(String titlerError) {
        this.titlerError = titlerError;
    }

    public ProductNotfoundException(String message, String titlerError) {
        super(message);
        this.titlerError = titlerError;
    }

    public ProductNotfoundException(String message, Throwable cause, String titlerError) {
        super(message, cause);
        this.titlerError = titlerError;
    }

    public ProductNotfoundException(Throwable cause, String titlerError) {
        super(cause);
        this.titlerError = titlerError;
    }

    public ProductNotfoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String titlerError) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.titlerError = titlerError;
    }
}
