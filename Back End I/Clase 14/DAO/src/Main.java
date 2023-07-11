import com.company.dao.AvionDAOH2;
import com.company.entidades.Avion;
import com.company.servicios.AvionService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Avion avionA = new Avion();

        avionA.setId(1L);
        avionA.setMarca("marcaA");
        avionA.setModelo("modeloA");
        avionA.setMatricula("matriculaA");
        avionA.setFechaServicio(LocalDate.of(2000,1,1));

        Avion avionB = new Avion();

        avionB.setId(2L);
        avionB.setMarca("marcaB");
        avionB.setModelo("modeloB");
        avionB.setMatricula("matriculaB");
        avionB.setFechaServicio(LocalDate.of(2000,1,1));

        AvionService avionService = new AvionService();
        avionService.setAvionIDAO(new AvionDAOH2());

        avionService.registrar(avionA);
        System.out.println(avionService.buscar(1L));
        avionService.registrar(avionB);
        System.out.println(avionService.buscarTodos());
        avionService.eliminar(1L);
        avionService.eliminar(2L);
        System.out.println(avionService.buscar(1L));
        System.out.println(avionService.buscarTodos());
    }
}