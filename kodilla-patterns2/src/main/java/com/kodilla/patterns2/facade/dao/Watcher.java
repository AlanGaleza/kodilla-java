package com.kodilla.patterns2.facade.dao;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component("facadeOrderWatcher")
@Aspect
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

/*    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(java.lang.Long))" + "&& args(userId) && target(object)")
    public void logEvent(Object object, Long userId) {
        LOGGER.info("Class: " + object.getClass().getName() + " Id number(args): " + userId.toString());
    }*/

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" + "&& args(orderDto, userId) && target(object)")
    public void logEvent(OrderDto orderDto, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() +
                " OrderDaoItems(args): " + orderDto.getItems().stream()
                        .map(item -> item.getProductId().toString())
                        .collect(Collectors.joining(";")) +
                " UsersId number(args): " + userId.toString());
    }
}

