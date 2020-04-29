package com.higao.apirestspring.resources;

import com.higao.apirestspring.entities.Order;
import com.higao.apirestspring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class OrderResource {

    @Autowired(required = true)
    private OrderService orderService;

    @GetMapping(value="/orders")
    public ResponseEntity<List<Order>> findAllOrders(){
        List<Order> orderList = orderService.findAll();
        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value="/order/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);

        return ResponseEntity.ok().body(order);
    }
}
