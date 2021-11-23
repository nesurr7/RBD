package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.Admin;
import users.User;

import java.io.IOException;
import java.sql.SQLException;

public class LogInController {

    public static Scene LOGIN_SCENE;
    @FXML
    private TextField loginArea;

    @FXML
    private TextField passwordArea;

    @FXML
    private Text textSignal;

    @FXML
    void loginIn(MouseEvent event) throws IOException, SQLException {
        String password = passwordArea.getText(),login = loginArea.getText();
        if(password.equals(Admin.password) && login.equals(Admin.login)){
            textSignal.setFill(Color.BLUE);
            textSignal.setText("Админ");
            //окно Админа
        }
        else if(Procedure.checkUsers(login,password)){
            Stage stage =(Stage) loginArea.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            stage.setTitle("Menu");
            stage.setScene(new Scene(root));
            User.login = login;
            User.password = password;
        }
        else {
            textSignal.setFill(Color.RED);
            textSignal.setText("Ошибка");
        }

    }

    @FXML
    void register(MouseEvent event) throws IOException {
        Stage stage =(Stage) loginArea.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Reg.fxml"));
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));
    }


}
