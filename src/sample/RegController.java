package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class RegController {
    @FXML
    private Button backMenu;

    @FXML
    void backToLogIn(MouseEvent event) throws IOException {
        Stage stage =(Stage) backMenu.getScene().getWindow();
        stage.setScene(LogInController.LOGIN_SCENE);
    }
}
