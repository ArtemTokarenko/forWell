package connectionToDB;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionToDB {

    public Statement getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/forwell?autoReconnect=true&useSSL=false",
                "root", "root");

        if (conn == null) {
            System.out.println("No database connection!");
            System.exit(0);
        }
        Statement stmt = conn.createStatement();

        return stmt;

    }
}

