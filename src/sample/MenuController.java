package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.User;

public class MenuController {

    @FXML
    private Button backMenu;

    @FXML
    void backToLogIn(MouseEvent event)  {
        Stage stage =(Stage) backMenu.getScene().getWindow();
        stage.setScene(LogInController.LOGIN_SCENE);
    }

    @FXML
    private Text meetingText;

    @FXML
    void meeting(MouseEvent event) {
        meetingText.setText("Вы зашли как, "+ User.login);
    }

}
