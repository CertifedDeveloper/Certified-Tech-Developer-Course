public class Main {
    public static void main(String[] args) {
        CentralItinerarios centralItinerarios = new CentralItinerarios();
        Vuelo vueloA = new Vuelo("OrigenA", "DestinoA", "HHA:mmA");
        Vuelo vueloB = new Vuelo("OrigenB", "DestinoB", "HHB:mmB");
        Portal portalA = new Portal("portalA");
        Portal portalB = new Portal("portalB");
        vueloA.agregarObservador(portalA);
        vueloA.agregarObservador(portalB);
        vueloB.agregarObservador(portalB);
        centralItinerarios.getVuelos().add(vueloA);
        centralItinerarios.notificarVuelos();
        centralItinerarios.getVuelos().add(vueloB);
        centralItinerarios.notificarVuelos();
    }
}