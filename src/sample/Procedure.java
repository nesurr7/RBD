package sample;
import Connector.JDBCPostgreSQL;
import Product.Product;
import Type.ProductType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

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

    public static void setProducts(TableView<Product> table,int type_id) {
        ObservableList<Product> list = FXCollections.observableArrayList();
        try {
            PreparedStatement stmt = selectStmt("""
                     SELECT product_name,manufacturer_name,material,color,volume,weight,price, product_id  from product_features  RIGHT JOIN
                    (SELECT product_name,features_id, manufacture_id,product_id FROM product_type LEFT JOIN products ON products.type_id = product_type.type_id where products.type_id = ?) as res1
                    ON res1.features_id = product_features.features_id
                    LEFT JOIN manufacturer ON res1.manufacture_id = manufacturer.manufacturer_id""");
            stmt.setInt(1,type_id);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                list.add(new Product(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getFloat(5), res.getFloat(6),res.getInt(7),res.getInt(8)));
                table.setItems(list);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setOrders(TableView<Order> table) {
        ObservableList<Order> list = FXCollections.observableArrayList();
        try {
            PreparedStatement stmt = selectStmt("""
                    SELECT order_id,type_name,product_name,
                    manufacturer_name,dis_cost,delivery_date,delivery_address FROM ((SELECT * FROM orders LEFT JOIN products ON
                    orders.product_id = products.product_id where orders.customer_id = ?) as res1 LEFT JOIN product_type ON res1.type_id = product_type.type_id) as res2 LEFT JOIN
                    manufacturer ON res2.manufacture_id = manufacturer.manufacturer_id""");
            stmt.setInt(1,User.user_id);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                list.add(new Order(res.getInt(1),res.getString(2),res.getString(3),
                        res.getString(4),res.getInt(5),res.getString(6),res.getString(7)));
                table.setItems(list);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean insertOrder(int product_id,int operator_id,int deliver_id, String delivery_date,String delivery_address,String payment_method,int price) {
        try {
            PreparedStatement stmt = JDBCPostgreSQL.con.prepareStatement("INSERT INTO orders" +
                    "(product_id,operator_id,deliver_id,customer_id,delivery_date,delivery_address,payment_method,dis_cost) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1,product_id);
            stmt.setInt(2,operator_id);
            stmt.setInt(3,deliver_id);
            stmt.setInt(4,User.user_id);
            stmt.setString(5,delivery_date);
            stmt.setString(6,delivery_address);
            stmt.setString(7,payment_method);
            stmt.setInt(8,price);
            return stmt.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static int randPerson(String employe) throws SQLException {
        ObservableList<ProductType> list = FXCollections.observableArrayList();
        String sql;
        if (employe.equals("deliver")) sql ="SELECT deliver_id FROM deliverers";
        else if (employe.equals("operator")) sql ="SELECT operator_id FROM operators";
        else return 0;
        ResultSet res=null;
        int counter=0;
        int counter2=0;
        try {
            res = select(sql);
            while (res.next()){
                counter++;
            }
            res = select(sql);
            } catch (SQLException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        int randint = (random.nextInt(counter-1)+1);
        while(res.next()){
            counter2++;
            if(randint == counter2) return res.getInt(1);
        }
        return 0;
    }



}