package store;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order){
        orders.add(order);
        return true;
    }

    public boolean cancelOrder(int id){
        //TODO: Отмена заказ
        return true;
    }

    public boolean paymentOrder(int id){
        //TODO: Отмена заказ
        return true;
    }

}
