package xyz.lexops.pontomaismais.exceptions;

public class TimeClockEntryNotFoundException extends RuntimeException {

    public TimeClockEntryNotFoundException(){
        super("Time clock entry not found.");
    }

    public TimeClockEntryNotFoundException(String string){
        super(string);
    }

}
