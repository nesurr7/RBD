package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RootMenuController {
    @FXML
    private Button backRoot;

    @FXML
    void backToLogin(MouseEvent event) {
        Stage stage =(Stage) backRoot.getScene().getWindow();
        stage.setScene(LogInController.LOGIN_SCENE);
    }

    @FXML
    private TextField id;

    @FXML
    private Text success;


    @FXML
    void deleteOrder(MouseEvent event) {
        success.setVisible(false);
        if(!(id.getText().equals(""))) {
            if (Procedure.deleteOrder(Integer.parseInt(id.getText()))){
                success.setVisible(true);
            }
        }
    }






}
