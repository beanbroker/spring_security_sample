package com.beanbroker.broker.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class BrokerUserEntity {

    @Id
    private String id;

    private String userId;

    private String password;

}
