import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Repos.IdbConnection;

public class DBConnection implements IdbConnection{
	   
		private String BDD = "nombd";
		private String url = "jdbc:mysql://localhost:3306/" + BDD;
		private String user = "root";
		private String passwd = "";
	    private Connection conn;
		private static DBConnection dbc;
	   
	    private DBConnection(){}

	    
	    public Connection getConn() throws SQLException {
			conn=DriverManager.getConnection(url, user,passwd);
			return conn;
		}

		public static DBConnection getDBConnection(){
			if(dbc == null){
			 
					dbc = new DBConnection();
		 
			}
			return dbc;
		} 

 
	
}
