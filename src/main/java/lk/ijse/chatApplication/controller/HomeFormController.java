package lk.ijse.chatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeFormController implements Initializable {
    public TextField txtjon;
    public ImageView btnjon;
    static String name="";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void txtjonOnActon(ActionEvent event) {
        btnjonClick();
    }

    public void btnjonClick() {
        String name = txtjon.getText();

        String[] words = name.split(" ");

        HomeFormController.name = words[0];

        if (txtjon.getText().equals("stop")) {
            System.exit(0);
            return;
        }

        if (txtjon.getText().equals("") || txtjon.getText().equals("please enter your name !")) {
            txtjon.setStyle("-fx-border-color: red");
            txtjon.setText("please enter your name !");
            txtjon.selectAll();
            return;
        }
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/client_form.fxml"));
        stage.getIcons().add(new Image("/assets/send3D.png"));
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.setTitle(HomeFormController.name + " in your chat");
        stage.show();
        stage.centerOnScreen();
        txtjon.clear();

    }
}
