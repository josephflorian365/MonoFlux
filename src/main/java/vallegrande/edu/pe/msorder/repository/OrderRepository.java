package vallegrande.edu.pe.msorder.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import vallegrande.edu.pe.msorder.dto.OrderDto;
import vallegrande.edu.pe.msorder.entity.Order;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    <T> Flux<T> saveAll(Flux<OrderDto> orderDtoFlux);
}
