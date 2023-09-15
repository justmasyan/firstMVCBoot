package mainpackage.maintask.proxy;

import mainpackage.maintask.Model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {
    @PostMapping("/payment")
    Payment createPayment(@RequestBody Payment payment,
    @RequestHeader String requestId);
}
