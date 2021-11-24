package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

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
        signalText.setFill(Color.RED);
        String fName = firstName.getText(), mName = middleName.getText(),lName = lastName.getText();
        ///////
        if(fName.length()<3 || mName.length()<3 || lName.length()<3){
            signalText.setText("Не верно указано ФИО");
            return;
        }
        ////
        String num=number.getText().replaceAll(" ","");
        ////
        if (num.length()!=11) {
            signalText.setText("Не верно указан номер");
            return;
        }
        /////
        else if(Procedure.checkNumber(num)){
            signalText.setText("Номер занят");
            return;
        }
        String log = login.getText(),pas = password.getText();
        /////
        if (log.length()<3 || log.length()>15 || pas.length()<5 || pas.length()>15) {
            signalText.setText("Не верно указан логин или пароль");
        }
        else if(Procedure.checkLogin(log)) {
            signalText.setText("Логин занят");
        }
        else{
            String FIO = lName+" "+fName+" "+mName;
            if(Procedure.insertUser(FIO,num,log,pas)){
                signalText.setFill(Color.GREEN);
                signalText.setText("Аккаунт зарегистрирован");
            }
        }
    }
}
