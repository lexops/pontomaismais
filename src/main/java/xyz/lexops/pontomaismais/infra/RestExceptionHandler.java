package xyz.lexops.pontomaismais.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import xyz.lexops.pontomaismais.exceptions.EmployeeNotFoundException;
import xyz.lexops.pontomaismais.exceptions.TimeClockEntryNotFoundException;
import xyz.lexops.pontomaismais.exceptions.UserNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    private ResponseEntity<String> employeeNotFoundHandler(EmployeeNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }

    @ExceptionHandler(TimeClockEntryNotFoundException.class)
    private ResponseEntity<String> timeClockEntryNotFoundHandler(TimeClockEntryNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time clock entry not found.");
    }

}
