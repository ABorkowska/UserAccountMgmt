package pl.entity;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();   }

    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context)initContext.lookup("java:/comp/env");
                dataSource = (DataSource)envContext.lookup("jdbc/users");
            } catch (NamingException e) { e.printStackTrace(); }
        }
        return dataSource;
    }

//    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8";
//    private static final String DB_USER = "root";
//    private static final String DB_PASS = "Donako22";

//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}