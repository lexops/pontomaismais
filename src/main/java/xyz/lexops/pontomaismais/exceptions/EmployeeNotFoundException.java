package xyz.lexops.pontomaismais.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(){
        super("Employee not found.");
    }

    public EmployeeNotFoundException(String string){
        super(string);
    }

}
