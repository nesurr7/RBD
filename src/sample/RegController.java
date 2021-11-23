package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class RegController {
    @FXML
    private Button backMenu;

    @FXML
    private TextField lastName;

    @FXML
    private TextField login;

    @FXML
    private TextField firstName;

    @FXML
    private TextField number;

    @FXML
    private TextField password;

    @FXML
    private TextField middleName;

    @FXML
    void backToLogIn(MouseEvent event)  {
        Stage stage =(Stage) backMenu.getScene().getWindow();
        stage.setScene(LogInController.LOGIN_SCENE);
    }

    @FXML
    private Text signalText;

    @FXML
    void register(MouseEvent event) throws SQLException {
        //signalText.setFill(Color.RED);
        String fName = firstName.getText(), mName = middleName.getText(),lName = lastName.getText(),
                num=number.getText(), log = login.getText(), pas = password.getText();
        if(fName.length()<3 || mName.length()<3 || lName.length()<3){
            signalText.setText("Не верно указано ФИО");
        }
        else if (num.length()!=15) signalText.setText("Не верно указан номер");
        else if (log.length()<3 || log.length()>15 || pas.length()<5 || pas.length()>15) {
            signalText.setText("Не верно указан логин или пароль");
        }
        else if(Procedure.checkLogin(log)) signalText.setText("Логин занят");
        else{
            signalText.setFill(Color.GREEN);
            signalText.setText("Аккаунт зарегистрирован");
        }

    }

}
