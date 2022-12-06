package Repos;

import java.sql.Connection;
import java.sql.SQLException;
public interface IdbConnection {
    
    public abstract Connection getConn()throws SQLException;

   
}