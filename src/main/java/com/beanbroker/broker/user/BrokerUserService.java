package com.beanbroker.broker.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrokerUserService implements UserDetailsService {


    private final BrokerUserRepository brokerUserRepository;


    public BrokerUserService(BrokerUserRepository brokerUserRepository) {
        this.brokerUserRepository = brokerUserRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        BrokerUserEntity user = brokerUserRepository.findBrokerUserByUserId(username);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();


        if (username.equals("admin")) {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.name()));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.USER.name()));
        }

        return new User(user.getUserId(), user.getPassword(), grantedAuthorities);
    }

}
