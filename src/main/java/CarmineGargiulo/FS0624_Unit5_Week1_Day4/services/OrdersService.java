package CarmineGargiulo.FS0624_Unit5_Week1_Day4.services;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.Order;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.exceptions.NotFoundException;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories.OrdersRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public void saveOrder(Order order){
        ordersRepository.save(order);
        System.out.println("Order nr " + order.getOrderId() + " from table " + order.getTable().getTableNr() + " successfully saved");
    }

    public Order getOrderById(long id){
        return ordersRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findByIdAndUpdate(long id, Order order){
        try{
            Order order1 = this.getOrderById(id);
            order1.setTotAmount(order.getTotAmount());
            order1.setOrderState(order.getOrderState());
            order1.setProductList(order.getProductList());
            ordersRepository.save(order);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
