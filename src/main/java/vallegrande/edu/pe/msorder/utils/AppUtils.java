package vallegrande.edu.pe.msorder.utils;

import org.springframework.beans.BeanUtils;
import vallegrande.edu.pe.msorder.dto.OrderDto;
import vallegrande.edu.pe.msorder.entity.Order;

public class AppUtils {

    public static OrderDto entityToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }

    public static Order dtotoEntity(OrderDto orderDto){
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        return order;
    }
}
