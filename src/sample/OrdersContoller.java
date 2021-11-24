package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        MenuController.MenuScene = new Scene(root);
        stage.setScene(MenuController.MenuScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
