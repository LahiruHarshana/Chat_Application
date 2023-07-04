package lk.ijse.chatApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/home_form.fxml"))));
        primaryStage.getIcons().add(new Image("assests/icons8-send-message-64.png"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("join chat");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}