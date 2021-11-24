package sample;
import Connector.JDBCPostgreSQL;
import Type.ProductType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Procedure {
    /*check logIn*/
    private static ResultSet select(String sql) throws SQLException {
        assert JDBCPostgreSQL.con != null;
        PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement(sql);
        return stmt.executeQuery();
    }

    private static PreparedStatement selectStmt(String sql) throws SQLException {
        assert JDBCPostgreSQL.con != null;
        PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement(sql);
        return stmt;
    }


    public static boolean checkUsers(String login, String password) throws SQLException {
        try {
            PreparedStatement stmt = selectStmt("SELECT customer_id,phone_number,login,user_password FROM customers where login = ? and user_password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                User.user_id = res.getInt("customer_id");
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean checkLogin(String login) {
        try {
            PreparedStatement stmt = selectStmt("SELECT login FROM customers where login = ?");
            stmt.setString(1,login);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean checkNumber(String num) {
        try {
            PreparedStatement stmt = selectStmt("SELECT phone_number FROM customers where phone_number = ?");
            stmt.setString(1,num);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                return true;
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

    public static void setTypes(TableView<ProductType> table) {
        ObservableList<ProductType> list = FXCollections.observableArrayList();
        try {
            ResultSet res = select("SELECT * FROM product_type");
            while (res.next()) {
                list.add(new ProductType(res.getInt(1),res.getString(2),res.getInt(3)));
                table.setItems(list);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }





}