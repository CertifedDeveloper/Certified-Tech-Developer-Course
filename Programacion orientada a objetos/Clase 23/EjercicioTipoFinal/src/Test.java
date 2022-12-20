public class Test {
    public static void main(String[] args) {
        Curso frontEnd = new Curso("Front End", "Curso de Front End", 16, 2,1000);
        System.out.println(frontEnd);
        Curso backEnd = new Curso("Back End", "Curso de Back End", 20, 2, 900);
        System.out.println(backEnd);
        Programa fullStack = new Programa("FullStack", "Programa FullStack", 20);
        fullStack.getCursos().add(frontEnd);
        fullStack.getCursos().add(backEnd);
        System.out.println(fullStack);
    }
}