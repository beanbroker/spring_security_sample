package com.beanbroker.broker;

import com.beanbroker.broker.user.BrokerUserEntity;
import com.beanbroker.broker.user.BrokerUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class SampleController {

    private final BrokerUserRepository brokerUserRepository;
    private final PasswordEncoder passwordEncoder;
    public SampleController(BrokerUserRepository brokerUserRepository, PasswordEncoder passwordEncoder) {
        this.brokerUserRepository = brokerUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/test")
    public void test(HttpSession httpSession){

        httpSession.setAttribute("uid", UUID.randomUUID().toString());
        Object uid = httpSession.getAttribute("uid");


    }

    @GetMapping("/create")
    public BrokerUserEntity memberJoin() {

        BrokerUserEntity user = new BrokerUserEntity();
        user.setId(UUID.randomUUID().toString());
        user.setUserId("1234");
        user.setPassword(passwordEncoder.encode("1234"));

        brokerUserRepository.save(user);

        BrokerUserEntity admin = new BrokerUserEntity();
        admin.setId(UUID.randomUUID().toString());
        admin.setUserId("admin");
        admin.setPassword(passwordEncoder.encode("1234"));

        brokerUserRepository.save(user);

        return user;
    }

}
