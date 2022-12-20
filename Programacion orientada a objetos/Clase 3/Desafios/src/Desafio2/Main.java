package Desafio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcionA;
        String opcionB;

        System.out.println("Ingresa nombre del primer jugador: ");
        String jugadorA = scanner.nextLine();
        System.out.println("Ingresa nombre del segundo jugador: ");
        String jugadorB = scanner.nextLine();
        while(true){
            System.out.println("Primer jugador: Ingresa piedra, papel, tijera o spock.");
            opcionA = scanner.nextLine();
            if (opcionA.equals("*")){
                return;
            }
            System.out.println("Segundo jugador: Ingresa piedra, papel, tijera o spock.");
            opcionB = scanner.nextLine();
            if (opcionB.equals("*")){
                return;
            }
            if ((opcionA.equals("papel") || opcionA.equals("piedra") || opcionA.equals("tijera") || opcionA.equals("spock")) && (opcionB.equals("papel") || opcionB.equals("piedra") || opcionB.equals("tijera") || opcionB.equals("spock"))){
                int ganador = cualGana(opcionA, opcionB);
                if (ganador == 1){
                    System.out.println("Gana " + jugadorA);
                } else if (ganador == 2){
                    System.out.println("Gana " + jugadorB);
                } else {
                    System.out.println("Empate");
                }
            } else{
                System.out.println("Deben ingresar valores válidos: piedra, papel, tijera o spock");
            }
        }
    }
    public static Integer cualGana(String opcionA, String opcionB){
            if ((opcionA.equals("piedra") && opcionB.equals("tijera")) || (opcionA.equals("papel") && opcionB.equals("piedra")) || (opcionA.equals("tijera") && opcionB.equals("papel")) || (opcionA.equals("spock") && (opcionB.equals("tijera") || opcionB.equals("piedra"))) || (opcionA.equals("papel") && opcionB.equals("spock"))){
                return 1;
            } else if ((opcionB.equals("piedra") && opcionA.equals("tijera")) || (opcionB.equals("papel") && opcionA.equals("piedra")) || (opcionB.equals("tijera") && opcionA.equals("papel")) || (opcionB.equals("spock") && (opcionA.equals("tijera") || opcionA.equals("piedra"))) || (opcionB.equals("papel") && opcionA.equals("spock"))){
                return 2;
            } else {
                return 0;
            }
    }
}