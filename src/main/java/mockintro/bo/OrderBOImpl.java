package mockintro.bo;

import mockintro.bo.exception.BOException;
import mockintro.dao.OrderDAO;
import mockintro.dto.Order;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO{

    private OrderDAO dao;

    @Override
    public boolean placeOrder(Order order) throws BOException {
        try{
            int result = dao.createOrder(order);
            if(result == 0){
                return false;
            }
        }catch(SQLException e){
            throw new BOException(e);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) throws BOException {
        try {
            Order order = this.dao.read(id);
            order.setStatus("Cancelled");
            int result = this.dao.update(order);
            if(result == 0){
                return false;
            }
        }catch(SQLException e){
            throw new BOException(e);
        }

        return true;
    }

    @Override
    public boolean deleteOrder(int id) throws BOException {
        try{
           int result = this.dao.delete(id);
           if(result == 0){
              return false;
           }
        }catch(SQLException e){
            throw new BOException(e);
        }
        return true;
    }

    public OrderDAO getDao() {
        return this.dao;
    }
    public void setDao(OrderDAO dao){
        this.dao = dao;
    }
}
