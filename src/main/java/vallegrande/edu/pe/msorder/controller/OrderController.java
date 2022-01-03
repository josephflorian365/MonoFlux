package vallegrande.edu.pe.msorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.msorder.dto.OrderDto;
import vallegrande.edu.pe.msorder.entity.Order;
import vallegrande.edu.pe.msorder.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public Flux<OrderDto> getOrders() {
        return service.getOrders();
    }

    @GetMapping("/{orderId}")
    public Mono<OrderDto> getOrder(@PathVariable String orderId) {
        return service.getOrder(orderId);
    }

    @PostMapping
    public Mono<OrderDto> saveOrder(@RequestBody Mono<OrderDto> orderDtoMono) {
        return service.saveOrder(orderDtoMono);
    }

    @PutMapping("update/{orderId}")
    public Mono<OrderDto> updateOrder(@RequestBody Mono<OrderDto> orderDtoMono, @PathVariable String orderId) {
        return service.updateOrder(orderDtoMono, orderId);
    }

    @DeleteMapping("delete/{orderId}")
    public Mono<Void> deleteOrder(@PathVariable String orderId) {
        return service.deleteOrder(orderId);
    }

    @PostMapping("/postOrders")
    public Flux<Order> saveOrders(@RequestBody Flux<Order> orders) {
        return service.saveOrders(orders);
    }
}
