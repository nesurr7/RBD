package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegController {
    @FXML
    private Button backMenu;

    @FXML
    void backToLogIn(MouseEvent event)  {
        Stage stage =(Stage) backMenu.getScene().getWindow();
        stage.setScene(LogInController.LOGIN_SCENE);
    }
}
