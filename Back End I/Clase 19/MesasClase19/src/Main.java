import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Contactos contacto = new Contactos("nombre", "mail", "telefono");
        FileOutputStream fileOutputStream = new FileOutputStream("OutputFile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(contacto);

        FileInputStream fileInputStream = new FileInputStream("OutputFile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        objectOutputStream.close();
        fileOutputStream.close();
    }
}