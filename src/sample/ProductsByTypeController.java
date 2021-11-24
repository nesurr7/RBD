package sample;

import Product.Product;
import Type.ProductType;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsByTypeController implements Initializable {
    public static ProductType selected;

    @FXML
    private TableView<Product> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textType.setText(selected.getType_name());
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        material.setCellValueFactory(new PropertyValueFactory<>("material"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Procedure.setProducts(table,selected.getId());
    }

    @FXML
    private Button backProducts;

    @FXML
    private Text textType;

    @FXML
    void backToMenu(MouseEvent event) throws IOException {
            Stage stage =(Stage) backProducts.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            MenuController.MenuScene = new Scene(root);
            stage.setScene(MenuController.MenuScene);
    }

    @FXML
    private TableColumn<Product, String> color;

    @FXML
    private TableColumn<Product, String> manufacturer;

    @FXML
    private TableColumn<Product, String> material;

    @FXML
    private TableColumn<Product, String> name;

    @FXML
    private TableColumn<Product, Integer> price;

    @FXML
    private TableColumn<Product, Float> volume;

    @FXML
    private TableColumn<Product, Float> weight;
}
