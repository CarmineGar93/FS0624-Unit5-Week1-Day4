package CarmineGargiulo.FS0624_Unit5_Week1_Day4.exceptions;

public class OccupiedOrUnmatchableTableException extends RuntimeException{
    public OccupiedOrUnmatchableTableException(){
        super("Sorry....table is occupied at the moment or has less seats than needed");
    }
}
