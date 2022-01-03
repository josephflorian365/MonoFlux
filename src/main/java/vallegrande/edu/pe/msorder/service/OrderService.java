package vallegrande.edu.pe.msorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.msorder.dto.OrderDto;
import vallegrande.edu.pe.msorder.entity.Order;
import vallegrande.edu.pe.msorder.repository.OrderRepository;
import vallegrande.edu.pe.msorder.utils.AppUtils;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    List<OrderDto> listOrderDto = new ArrayList<OrderDto>();

    public Flux<OrderDto> getOrders() {
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<OrderDto> getOrder(String orderId) {
        return repository.findById(orderId).map(AppUtils::entityToDto);
    }

    public Mono<OrderDto> saveOrder(Mono<OrderDto> orderDtoMono) {
        return orderDtoMono.map(AppUtils::dtotoEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<OrderDto> updateOrder(Mono<OrderDto> orderDtoMono, String orderId) {
        return repository.findById(orderId)
                .flatMap(p -> orderDtoMono.map(AppUtils::dtotoEntity))
                .doOnNext(e -> e.setOrderId(orderId))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteOrder(String orderId) {
        return repository.deleteById(orderId);
    }

    public Flux<Order> saveOrders(Flux<Order> orderFlux) {
        return repository.saveAll(orderFlux);
    }
}
