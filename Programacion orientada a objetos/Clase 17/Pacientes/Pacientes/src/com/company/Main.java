package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	    try{
            Paciente paciente = new Paciente("Juan","Perez","12345", LocalDate.of(2025, 5, 10));
            paciente.darAlta(LocalDate.of(2000, 1, 1));
        } catch (FirstException | SecondException exception){
            System.err.println(exception);
        }
    }
}
