package mockintro.bo.exception;

import java.sql.SQLException;

public class BOException extends Exception{
    public BOException(){
        super();
    }

    public BOException(SQLException e) {
        super(e);
    }
}

