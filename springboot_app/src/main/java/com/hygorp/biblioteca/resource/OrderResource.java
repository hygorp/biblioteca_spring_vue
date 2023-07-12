package com.hygorp.biblioteca.resource;

import com.hygorp.biblioteca.domain.Order;
import com.hygorp.biblioteca.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Order> findByClientId(@PathVariable Integer id){
        Order obj = orderService.findByClientId(id);
        return ResponseEntity.ok().body(obj);
    }
}
