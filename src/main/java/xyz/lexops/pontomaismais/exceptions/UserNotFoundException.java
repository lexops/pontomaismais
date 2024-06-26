package xyz.lexops.pontomaismais.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){
        super("User not found.");
    }

    public UserNotFoundException(String string){
        super(string);
    }

}
