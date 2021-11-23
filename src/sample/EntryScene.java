package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EntryScene extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        primaryStage.setTitle("LogIn");
        LogInController.LOGIN_SCENE = new Scene(root);
        primaryStage.setScene(LogInController.LOGIN_SCENE);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
