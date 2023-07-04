package lk.ijse.chatApplication.controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    public void mouseEnterAnim(MouseEvent event) {
        if (event.getSource() instanceof javafx.scene.image.ImageView) {
            javafx.scene.image.ImageView icon = (ImageView) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
//            glow.setColor(Color.valueOf("#EF233C"));
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(15);
            glow.setHeight(15);
            glow.setRadius(15);
            icon.setEffect(glow);
        }
    }

    public void mouseExitAnim(MouseEvent event) {
    }
}
