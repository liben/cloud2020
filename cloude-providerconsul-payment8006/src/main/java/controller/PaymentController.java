package controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author liben
 * @date 2020/4/21 14:54
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "springCloud with consul :" + SERVER_PORT + "\t" + UUID.randomUUID().toString();
    }
}
