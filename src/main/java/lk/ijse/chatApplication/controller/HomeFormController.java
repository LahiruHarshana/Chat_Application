package lk.ijse.chatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    }
}
