package sample;

import Type.ProductType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.User;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public static Scene MenuScene;

    @FXML
    private Button backMenu;

    @FXML
    void backToLogIn(MouseEvent event)  {
        Stage stage =(Stage) backMenu.getScene().getWindow();
        stage.setScene(LogInController.LOGIN_SCENE);
    }

    @FXML
    private TableView<ProductType> table;

    @FXML
    private TableColumn<ProductType, Integer> id;

    @FXML
    private TableColumn<ProductType, Integer> discount;

    @FXML
    private TableColumn<ProductType, String> type_name;

    @FXML
    private Text meetingText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        meetingText.setText("Вы зашли как, "+ User.login);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type_name.setCellValueFactory(new PropertyValueFactory<>("type_name"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        Procedure.setTypes(table);
        //types.getSelectionModel().getSelectedIndex();
    }
}
