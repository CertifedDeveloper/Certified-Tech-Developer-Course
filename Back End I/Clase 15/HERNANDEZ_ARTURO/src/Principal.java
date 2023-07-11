import DAO.Impl.PacienteDAOH2;
import Model.Direccion;
import Model.Paciente;
import Service.PacienteService;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Direccion d = new Direccion("Rioja", 234,"San Juan", "San Juan");
        Paciente p = new Paciente("Jose", "Lorenzini","23424" , LocalDate.now(), d);

        PacienteService pepe = new PacienteService(new PacienteDAOH2());


        //System.out.println(pepe.guardar(p));
        System.out.println(pepe.leer(1));
        //pepe.eliminar(3);
        System.out.println(pepe.leer(3));
        System.out.println(pepe.buscarTodos());


    }
}
