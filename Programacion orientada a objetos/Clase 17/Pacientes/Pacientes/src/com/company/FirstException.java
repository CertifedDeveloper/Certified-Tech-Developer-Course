package com.company;

public class FirstException extends Exception{
    public FirstException(){
        super();
    }
    public FirstException(String mensaje){
        super(mensaje);
    }

    @Override
    public String toString() {
        return "Exception: "+ this.getClass().getName() + "\n" +
                "Mensaje: " + this.getMessage();
    }
}
