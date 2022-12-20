public class Main {
    public static void main(String[] args) {
        class Mascota{
            public String nombre;
            public Integer edad;
            public String comida;
            public String respuesta;
            Mascota(String nombre, Integer edad, String comida, String respuesta){
                this.nombre = nombre;
                this.edad = edad;
                this.comida = comida;
                this.respuesta = respuesta;
            }
            public void display()
            {
                System.out.println(nombre + " tiene " + edad + " años");
                System.out.println(nombre + " come " + comida + " y hace " + respuesta);
                System.out.println();
            }
        }

        Mascota[] arr;

        arr = new Mascota[5];

        arr[0] = new Mascota("Manchitas", 2, "1 kilo y medio", "guau guau");
        arr[1] = new Mascota("Nemo", 1, "140 gramos", "blu blu");
        arr[2] = new Mascota("Silvestre", 3, "medio kilo", "miau miau");
        arr[3] = new Mascota("Manuelita", 12, "300 gramos", "vivo en Pehuajó");
        arr[4] = new Mascota("Gardel", 1, "350 gramos", "piu piu");

        for (Integer i = 0; i < arr.length; i++){
            arr[i].display();
        }
    }
}