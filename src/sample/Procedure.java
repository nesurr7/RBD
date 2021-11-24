package sample;
import Connector.JDBCPostgreSQL;
import users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Procedure {
    /*check logIn*/
    public static boolean checkUsers(String login, String password) {
        try {
            assert JDBCPostgreSQL.con != null;
            PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement("SELECT customer_id,login,user_password FROM customers");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                if (res.getString("login").equals(login) && res.getString("user_password").equals(password)) {
                    User.user_id=res.getInt("customer_id");
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static boolean checkLogin(String login) {
        try {
            assert JDBCPostgreSQL.con != null;
            PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement("SELECT login FROM customers");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                if (res.getString(1).equals(login)) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean checkNumber(String num) {
        try {
            assert JDBCPostgreSQL.con != null;
            PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement("SELECT phone_number FROM customers");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                if (res.getString(1).equals(num)) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean insertUser(String FIO, String phone, String login, String password) {
        try {
            PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement("INSERT INTO customers" +
                    "(full_name,phone_number,login,user_password) VALUES (?,?,?,?)");
            stmt.setString(1,FIO);
            stmt.setString(2,phone);
            stmt.setString(3,login);
            stmt.setString(4,password);
            return stmt.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }





}