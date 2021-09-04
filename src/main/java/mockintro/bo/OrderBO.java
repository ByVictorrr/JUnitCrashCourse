package mockintro.bo;

import mockintro.bo.exception.BOException;
import mockintro.dto.Order;

public interface OrderBO {
    boolean placeOrder(Order order) throws BOException;
    boolean cancelOrder(int id) throws BOException;
    boolean deleteOrder(int id) throws BOException;
}
