package com.beanbroker.broker.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private final BrokerUserRepository brokerUserRepository;

    public UserController(BrokerUserRepository brokerUserRepository) {
        this.brokerUserRepository = brokerUserRepository;

    }

    @GetMapping("/users")
    public User getUser(@AuthenticationPrincipal User user){
        User user1 = user;
        return user1;
    }
}
