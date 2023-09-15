package mainpackage.PastTask.REST.beans;

import mainpackage.PastTask.REST.NotEnoughMoneyException;
import mainpackage.PastTask.REST.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processMoney(){
        throw new NotEnoughMoneyException();

    }
}
