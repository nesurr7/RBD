package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgreSQL {

    static final String DB_URL = "jdbc:postgresql://ec2-54-228-95-1.eu-west-1.compute.amazonaws.com:5432/d4q8q3kuoqaf8o";
    static final String USER = "eggsboqqpocklp";
    static final String PASS = "76ed9c15bba684966b9c005ea30d996c8380212f4f4b2c90e4b6d3025e39db43";
    public static Connection con;
    static {
        try {
            con = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Не удалось установить соединение");
        }
    }
}