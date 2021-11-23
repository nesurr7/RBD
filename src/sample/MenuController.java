package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.User;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button backMenu;

    @FXML
    void backToLogIn(MouseEvent event) throws IOException {
        Stage stage =(Stage) backMenu.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        stage.setTitle("LogIn");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private Text meetingText;

    @FXML
    void meeting(MouseEvent event) {
        meetingText.setText("Вы зашли как, "+ User.login);
    }

}
