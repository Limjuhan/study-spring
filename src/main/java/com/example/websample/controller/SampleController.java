package com.example.websample.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SampleController {

    @GetMapping(value = "/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id) throws IllegalAccessException {
        log.info("Get some order" + id);

        if ("500".equals(id)) {
            throw new IllegalAccessException("500 is not valid orderId.");
        }

        return "orderId: " + id + " , orderAmount:1000";
    }

    @DeleteMapping(value = "/order/{orderId}")
    public String deleteOrder(@PathVariable("orderId") String id) {
        log.info("Get some order" + id);

        return "Delete orderId: " + id;
    }

    @GetMapping(value = "/order")//param을 여러개받을시
    public String getOrderWithRequestParam(@RequestParam("orderId") String id,
                                           @RequestParam("orderAmount") String amount) {
        log.info("Get some order" + id + ", amount: " + amount);

        return "orderId: " + id + " , orderAmount: " + amount;
    }

    @PostMapping(value = "/order")
    public String createOrder(@RequestBody CreateOrderRequest createOrderRequest,
                              @RequestHeader String userAccountId) {
        log.info("Create order: " + createOrderRequest + ", " +
                "userAccountId: " + userAccountId);

        return "orderId: " + createOrderRequest.getOrderId() + " , " +
                "orderAmount:1000" + createOrderRequest.getOrderAmount();
    }

    @PutMapping(value = "/order")
    public String createOrder() {
        log.info("Create order");

        return "order created -> orderId:1, orderAmount:1000";
    }

    @Data // 롬복. getter, setter자동생성해준다.
    public static class CreateOrderRequest {
        private String orderId;
        private Integer orderAmount;


    }
}
