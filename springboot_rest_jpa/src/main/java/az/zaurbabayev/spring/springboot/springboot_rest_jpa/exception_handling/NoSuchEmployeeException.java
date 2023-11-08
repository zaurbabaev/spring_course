package az.zaurbabayev.spring.springboot.springboot_rest_jpa.exception_handling;

public class NoSuchEmployeeException extends RuntimeException{
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
