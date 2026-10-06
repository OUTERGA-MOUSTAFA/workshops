package ma.youcode.workshop.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

    private static final DataSource dataSource;

    static{
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/GestionEcoleDS");
        } catch (NamingException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    
}
