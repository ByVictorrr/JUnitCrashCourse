package mockintro.bo;

import mockintro.bo.exception.BOException;
import mockintro.dao.OrderDAO;
import mockintro.dto.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class OrderBOImplTest {

    @Mock
    OrderDAO dao;
    private OrderBOImpl bo;

    @BeforeEach
    public void setup(){
        /* scans through all variable that have @Mock
            that will be mocked out or create a proxy
         */
        MockitoAnnotations.initMocks(this);
        this.bo = new OrderBOImpl();
        this.bo.setDao(this.dao);
    }

    @Test // not testing for exceptions so throw execeptions
    public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
        Order order = new Order();
        // used to stub out the method calls on a mocked object
        when(this.dao.createOrder(order)).thenReturn(new Integer(1)); // set expectation (return result when called)
        boolean result = this.bo.placeOrder(order);
        Assertions.assertTrue(result);
        verify(this.dao).createOrder(order); // make sure dao.createOrder() is getting called at least once


    }
    @Test // not testing for exceptions so throw execeptions
    public void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException {
        Order order = new Order();
        // used to stub out the method calls on a mocked object
        when(this.dao.createOrder(order)).thenReturn(new Integer(0)); // set expectation (return result when called)
        boolean result = this.bo.placeOrder(order);
        Assertions.assertFalse(result);
        verify(this.dao).createOrder(order); // make sure dao.createOrder() is getting called at least once

    }
    @Test
    public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
        Order order = new Order();
        when(this.dao.createOrder(order)).thenThrow(SQLException.class);
        Assertions.assertThrows(BOException.class, ()->{
            this.bo.placeOrder(order);
        });
        verify(this.dao).createOrder(order);

    }
    @Test
    public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
        Order order = new Order();
        when(this.dao.read(123)).thenReturn(order);
        when(this.dao.update(order)).thenReturn(new Integer(1));
        boolean result = bo.cancelOrder(123);
        Assertions.assertTrue(result);
        verify(this.dao).read(123);
        verify(this.dao).update(order);

    }
    @Test
    public void cancelOrder_Should_NOT_Cancel_The_Order() throws SQLException, BOException {
        Order order = new Order();
        when(this.dao.read(123)).thenReturn(order);
        when(this.dao.update(order)).thenReturn(new Integer(0));
        boolean result = bo.cancelOrder(123);
        Assertions.assertFalse(result);
        verify(this.dao).read(123);
        verify(this.dao).update(order);
    }
    @Test
    public void cancelOrder_Should_Throw_A_BOException_On_Read() throws SQLException{
        when(this.dao.read(123)).thenThrow(SQLException.class);
        Assertions.assertThrows(BOException.class, ()->{
            this.bo.cancelOrder(123);
        });
        verify(this.dao).read(123);
    }

    @Test
    public void cancelOrder_Should_Throw_A_BOException_On_Update() throws SQLException, BOException {
        Order order = new Order();
        when(this.dao.read(123)).thenReturn(order);
        when(this.dao.update(order)).thenThrow(SQLException.class);
        Assertions.assertThrows(BOException.class, ()->{
            this.bo.cancelOrder(123);
        });
        verify(this.dao).read(123);
        verify(this.dao).update(order);
    }


}
