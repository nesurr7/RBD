package sample;
import Connector.JDBCPostgreSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Procedure {
    /*check logIn*/
    public static boolean checkUsers(String login, String password) throws SQLException {
        try {
            assert JDBCPostgreSQL.con != null;
            PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement("SELECT login,user_password FROM customers");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                if (res.getString("login").equals(login) && res.getString("user_password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }





}