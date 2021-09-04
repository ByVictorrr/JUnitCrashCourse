package mockintro.dao;

import mockintro.dto.Order;

import java.sql.SQLException;

public interface OrderDAO {
    int createOrder(Order o) throws SQLException;
    Order read(int id) throws SQLException;
    int update(Order order) throws SQLException;
    int delete(int id) throws SQLException;
}
