public class Test {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Empresa");
        UnidadTrabajo simpleA = UnidadTrabajoFactory.getInstancia().crearUnidadTrabajo("Simple");
        simpleA.setNombre("Mantenimiento");
        simpleA.setDescripcion("Unidad de Mantenimiento");
        ((Simple)simpleA).setCantidadPersonas(4);
        ((Simple)simpleA).setMontoPersona(120000);
        UnidadTrabajo simpleB = UnidadTrabajoFactory.getInstancia().crearUnidadTrabajo("Simple");
        simpleB.setNombre("Limpieza");
        simpleB.setDescripcion("Unidad de Limpieza");
        ((Simple)simpleB).setCantidadPersonas(24);
        ((Simple)simpleB).setMontoPersona(100000);
        UnidadTrabajo combinadaA = UnidadTrabajoFactory.getInstancia().crearUnidadTrabajo("Combinada");
        combinadaA.setNombre("Servicios Generales");
        combinadaA.setDescripcion("Combinada de Servicios Generales");
        ((Combinada)combinadaA).setCoeficienteGlobal(3);
        ((Combinada)combinadaA).getUnidades().add(simpleA);
        ((Combinada)combinadaA).getUnidades().add(simpleB);
        empresa.getUnidades().add(simpleA);
        empresa.getUnidades().add(simpleB);
        empresa.getUnidades().add(combinadaA);
        empresa.mostrarInforme();
    }
}