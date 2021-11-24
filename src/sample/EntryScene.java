package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EntryScene extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/LogIn.fxml"));
        Image image = new Image("rsc/icon.jpg");
        LogInController.LOGIN_SCENE = new Scene(root);
        primaryStage.setScene(LogInController.LOGIN_SCENE);
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
