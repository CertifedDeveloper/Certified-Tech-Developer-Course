public class Main {
    public static void main(String[] args) {
        Reparacion reparacion = ReparacionFactory.getInstance().crearReparacion("batidora");
        try{
            reparacion.valorPresupuesto(2000);
            reparacion.sumarRepuesto(500);
            reparacion.cambiarDireccion("Dirección");

        } catch (Exception e){
            System.out.println(e);
        }
        reparacion.pasarSigPaso();
        try{
            reparacion.sumarRepuesto(500);
        } catch (Exception e){
            System.out.println(e);
        }
        reparacion.pasarSigPaso();
        try{
            reparacion.cambiarDireccion("Dirección");
        } catch (Exception e){
            System.out.println(e);
        }
        reparacion.pasarSigPaso();
    }
}