package mainpackage.PastTask.REST.beans;


import mainpackage.PastTask.REST.NotEnoughMoneyException;
import mainpackage.PastTask.REST.ErrorDetails;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<?> exceptionNotEnoughMoney(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("not enough money");
        return ResponseEntity.badRequest()
                .body(errorDetails);
    }
}
