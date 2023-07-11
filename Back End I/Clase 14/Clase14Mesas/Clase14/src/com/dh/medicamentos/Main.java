package com.dh.medicamentos;

import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;
import com.dh.medicamentos.service.MedicamentoService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());

        Medicamento medicamento = new Medicamento("Ibuprofeno", "lab123", 1000, 200.0);
        Medicamento medicamento1 = medicamentoService.guardar(medicamento);
        Medicamento medicamento2 = medicamentoService.buscar(1);
        ArrayList<Medicamento> medicamentos = medicamentoService.buscarTodos();
        //System.out.println(medicamento1);
        //System.out.println(medicamento2);
        System.out.println(medicamentos);

        // write your code here
    }
}
