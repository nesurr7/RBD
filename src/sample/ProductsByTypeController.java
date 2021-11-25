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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.Procedure.insertOrder;

public class ProductsByTypeController implements Initializable {
    public static ProductType selected;
    public static int discount;
    public static Product selectedProduct;
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
            Parent root = FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
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

    @FXML
    private TextField address;

    @FXML
    private TextField date;

    @FXML
    private TextField method;

    @FXML
    private Text error1;

    @FXML
    private Text error2;

    @FXML
    private Text error3;

    @FXML
    private Text error4;

    @FXML
    void orderInit(MouseEvent event) throws SQLException {
        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        ProductsByTypeController.selectedProduct = table.getSelectionModel().getSelectedItem();
        boolean flag = false;
        int pr;
        int res = 0;
        if (ProductsByTypeController.selectedProduct==null) {
            error4.setVisible(true);
            flag=true;
        }
        else {
            pr = ProductsByTypeController.selectedProduct.getPrice();//цена есть
            res = Math.round(pr - ((float)discount/100)*pr);
        }
        if (date.getText().length() != 10) {
            error1.setVisible(true);
            flag=true;
        }
        if (address.getText().length()<40) {
            error2.setVisible(true);
            flag=true;
        }
        if (!(method.getText().equals("Наличными") || method.getText().equals("Онлайн"))) {
            error3.setVisible(true);
            flag=true;
        }

        if(!flag)insertOrder(ProductsByTypeController.selectedProduct.getId(),Procedure.randPerson("operator"),
                Procedure.randPerson("deliver"),date.getText(),address.getText(),method.getText(),res);
    }
}
