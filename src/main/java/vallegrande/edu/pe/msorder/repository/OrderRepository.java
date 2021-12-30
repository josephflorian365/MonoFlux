package vallegrande.edu.pe.msorder.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import vallegrande.edu.pe.msorder.entity.Order;
@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

}
