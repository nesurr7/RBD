package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrdersContoller implements Initializable {
    @FXML
    private Button backOrders;

    @FXML
    void backToMenu(MouseEvent event) throws IOException {
        Stage stage =(Stage) backOrders.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
        MenuController.MenuScene = new Scene(root);
        stage.setScene(MenuController.MenuScene);
    }

    @FXML
    private TableColumn<Order, String> address;

    @FXML
    private TableColumn<Order, Integer> cost;

    @FXML
    private TableColumn<Order, String> date;

    @FXML
    private TableColumn<Order, Integer> id;

    @FXML
    private TableColumn<Order, String> manufacturer;

    @FXML
    private TableColumn<Order, String> name;

    @FXML
    private TableView<Order> table;

    @FXML
    private TableColumn<Order, String> type;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_name"));
        name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer_name"));
        cost.setCellValueFactory(new PropertyValueFactory<>("dis_cost"));
        date.setCellValueFactory(new PropertyValueFactory<>("delivery_date"));
        address.setCellValueFactory(new PropertyValueFactory<>("delivery_address"));
        Procedure.setOrders(table);
    }
}
