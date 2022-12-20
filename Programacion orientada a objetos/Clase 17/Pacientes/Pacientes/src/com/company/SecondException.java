package com.company;

public class SecondException extends Exception{
    public SecondException(){
        super();
    }
    public SecondException(String mensaje){
        super(mensaje);
    }

    @Override
    public String toString() {
        return "Exception: "+ this.getClass().getName() + "\n" +
                "Mensaje: " + this.getMessage();
    }
}
