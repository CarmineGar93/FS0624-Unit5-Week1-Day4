package CarmineGargiulo.FS0624_Unit5_Week1_Day4.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id){
        super("Element with id " + id + " has not been found");
    }
}
