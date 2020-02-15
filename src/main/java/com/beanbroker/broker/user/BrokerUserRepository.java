package com.beanbroker.broker.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerUserRepository extends JpaRepository<BrokerUserEntity, Long> {

    BrokerUserEntity findBrokerUserByUserId(String userId);

}