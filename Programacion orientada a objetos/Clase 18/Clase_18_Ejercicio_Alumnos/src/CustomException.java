public class CustomException extends Exception {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Exception: " + this.getClass().getName() + "\n" +
                "Mensaje: " + this.getMessage();
    }
}
