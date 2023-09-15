package mainpackage.PastTask.REST.beans;

import mainpackage.PastTask.REST.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<?> makePayment(){
            PaymentDetails paymentDetails = paymentService.processMoney();
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
    }

    private final Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<?> postPayment(@RequestBody PaymentDetails paymentDetails){
        logger.info("Received amount:" + paymentDetails.getAmount());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
