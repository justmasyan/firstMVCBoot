package mainpackage.maintask.Controller;

import mainpackage.maintask.Model.Payment;
import mainpackage.maintask.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;
    PaymentsController(PaymentsProxy paymentsProxy){
        this.paymentsProxy = paymentsProxy;
    }
    private static Logger logger = Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payments")
    public Payment createPayment(
            @RequestBody Payment payment
    ){
        logger.info("Payment amount:" + payment.getAmount());
        String id = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(payment,id);
    }
}
