package lk.ijse.chatApplication.controller;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    @FXML
    private Label lblClientName;
    @FXML
    private TextField txtMessage;
    @FXML
    private ImageView btnSend;
    @FXML
    private VBox msgVboxAp;
    @FXML
    private Label lblimg1;
    @FXML
    private Label lblimg2;
    @FXML
    private Label lblimg3;
    @FXML
    private Label lblimg4;
    @FXML
    private Label lblimg5;
    @FXML
    private Label lblimg6;
    @FXML
    private ImageView btnLogOut;

    private List<String> fileList;

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private String clientName;

    private final byte[] emojiByteCode = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8C};
    private final byte[] emojiByteCode1 = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8D};
    private final byte[] emojiByteCode2 = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8F};
    private final byte[] emojiByteCode3 = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x93};
    private final byte[] emojiByteCode4 = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x98};
    private final byte[] emojiByteCode5 = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x82};

    private final String img1 = new String(emojiByteCode, Charset.forName("UTF-8"));
    private final String img2 = new String(emojiByteCode1, Charset.forName("UTF-8"));
    private final String img3 = new String(emojiByteCode2, Charset.forName("UTF-8"));
    private final String img4 = new String(emojiByteCode3, Charset.forName("UTF-8"));
    private final String img5 = new String(emojiByteCode4, Charset.forName("UTF-8"));
    private final String img6 = new String(emojiByteCode5, Charset.forName("UTF-8"));

    @FXML
    void initialize(){
        setImoji();
        lblClientName.setText(HomeFormController.name);
        clientName = lblClientName.getText();
        fileList=new ArrayList<>();
        fileList.add("*.jpg");
        fileList.add("*.doc");
        fileList.add("*.png");
        fileList.add("*.pdf");

        new Thread(()->{
            try (Socket socket = new Socket("localhost",3031);){

                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());

                String message = "";

                L1:
                while (!message.equals("finish")){

                    message = inputStream.readUTF();

                    String msg = message;
                    String[] words = msg.split(" ");
                    String clientName = words[0];


                    StringBuilder nameWithoutMsg = new StringBuilder();
                    for (int i = 1; i < words.length; i++) {
                        nameWithoutMsg.append(words[i]+" ");
                    }

                    HBox hBox = new HBox(12);

                    if (clientName.equalsIgnoreCase(lblClientName.getText())){

                        if (words[1].equals("imoji")){
                            if (words[2].equals("imoji01")){
                                String myMsg = "Me "+img1;
                                Label label = new Label();
                                label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
                                label.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                                label.setStyle("-fx-font-size: 20");
                                label.setText(myMsg);
                                hBox.setAlignment(Pos.BOTTOM_RIGHT);
                                hBox.getChildren().add(label);
                                Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                            }else if(words[2].equals("imoji02")){
                                String myMsg = "Me "+img2;
                                Label label = new Label();
                                label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
                                label.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                                label.setStyle("-fx-font-size: 20");
                                label.setText(myMsg);
                                hBox.setAlignment(Pos.BOTTOM_RIGHT);
                                hBox.getChildren().add(label);
                                Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                            }else if(words[2].equals("imoji03")){
                                String myMsg = "Me "+img3;
                                Label label = new Label();
                                label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
                                label.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                                label.setStyle("-fx-font-size: 20");
                                label.setText(myMsg);
                                hBox.setAlignment(Pos.BOTTOM_RIGHT);
                                hBox.getChildren().add(label);
                                Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                            }else if(words[2].equals("imoji04")){
                                String myMsg = "Me "+img4;
                                Label label = new Label();
                                label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
                                label.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                                label.setStyle("-fx-font-size: 20");
                                label.setText(myMsg);
                                hBox.setAlignment(Pos.BOTTOM_RIGHT);
                                hBox.getChildren().add(label);
                                Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                            }else if(words[2].equals("imoji05")){
                                String myMsg = "Me "+img5;
                                Label label = new Label();
                                label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
                                label.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                                label.setStyle("-fx-font-size: 20");
                                label.setText(myMsg);
                                hBox.setAlignment(Pos.BOTTOM_RIGHT);
                                hBox.getChildren().add(label);
                                Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                            }else {
                                String myMsg = "Me "+img6;
                                Label label = new Label();
                                label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
                                label.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                                label.setStyle("-fx-font-size: 20");
                                label.setText(myMsg);
                                hBox.setAlignment(Pos.BOTTOM_RIGHT);
                                hBox.getChildren().add(label);
                                Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                            }
                        } else if(!words[1].equals("img")){

                            String myMsg = "Me "+nameWithoutMsg;
                            Label label = new Label();
                            label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
                            label.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                            label.setStyle("-fx-font-size: 15");
                            label.setText(myMsg);
                            hBox.setAlignment(Pos.BOTTOM_RIGHT);
                            hBox.getChildren().add(label);
                            Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                        }

                    }else if( words[1].equals("img")){

                        String s ="";
                        for (int i = 2; i < words.length; i++) {
                            s += words[i];
                        }
                        Label label = new Label();
                        label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                        label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                        label.setStyle("-fx-font-size: 20");
                        label.setText(clientName);

                        File file = new File(s);
                        Image image = new Image(file.toURI().toString());

                        ImageView imageView = new ImageView(image);

                        imageView.setFitWidth(150);
                        imageView.setFitHeight(150);

                        hBox.setAlignment(Pos.BOTTOM_RIGHT);

                        msgVboxAp.setAlignment(Pos.BOTTOM_LEFT);
                        hBox.setAlignment(Pos.CENTER_LEFT);

                        hBox.getChildren().add(label);
                        hBox.getChildren().add(imageView);

                        Platform.runLater(() -> msgVboxAp.getChildren().addAll(hBox));


                    }else if(words[1].equals("imoji")){

                        if (words[2].equals("imoji01")){
                            String imojiRecuve = words[0]+":"+img1;
                            Label label = new Label();
                            label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                            label.setStyle("-fx-font-size: 20");
                            label.setText(imojiRecuve);
                            hBox.setAlignment(Pos.BOTTOM_LEFT);
                            hBox.getChildren().add(label);
                            Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                        }else if(words[2].equals("imoji02")){
                            String imojiRecuve = words[0]+":"+img2;
                            Label label = new Label();
                            label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                            label.setStyle("-fx-font-size: 20");
                            label.setText(imojiRecuve);
                            hBox.setAlignment(Pos.BOTTOM_LEFT);
                            hBox.getChildren().add(label);
                            Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                        }else if(words[2].equals("imoji03")){
                            String imojiRecuve = words[0]+":"+img3;
                            Label label = new Label();
                            label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                            label.setStyle("-fx-font-size: 20");
                            label.setText(imojiRecuve);
                            hBox.setAlignment(Pos.BOTTOM_LEFT);
                            hBox.getChildren().add(label);
                            Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                        }else if(words[2].equals("imoji04")){
                            String imojiRecuve = words[0]+":"+img4;
                            Label label = new Label();
                            label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                            label.setStyle("-fx-font-size: 20");
                            label.setText(imojiRecuve);
                            hBox.setAlignment(Pos.BOTTOM_LEFT);
                            hBox.getChildren().add(label);
                            Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                        }else if(words[2].equals("imoji05")){
                            String imojiRecive = words[0]+":"+img5;
                            Label label = new Label();
                            label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                            label.setStyle("-fx-font-size: 20");
                            label.setText(imojiRecive);
                            hBox.setAlignment(Pos.BOTTOM_LEFT);
                            hBox.getChildren().add(label);
                            Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                        } else {
                            String imojiRecive = words[0]+":"+img6;
                            Label label = new Label();
                            label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                            label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                            label.setStyle("-fx-font-size: 20");
                            label.setText(imojiRecive);
                            hBox.setAlignment(Pos.BOTTOM_LEFT);
                            hBox.getChildren().add(label);
                            Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                        }

                    }else {
                        String riciveMsg = message;
                        Label label = new Label();
                        label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                        label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
                        label.setStyle("-fx-font-size: 20");
                        label.setText(riciveMsg);
                        hBox.setAlignment(Pos.BOTTOM_LEFT);
                        hBox.getChildren().add(label);
                        Platform.runLater(()->msgVboxAp.getChildren().addAll(hBox));
                    }
                }

            } catch (IOException e) {
                System.out.println("disconnected !");
            }
        }).start();
    }

    private void setImoji() {
        //https://apps.timwhitlock.info/emoji/tables/unicode#emoji-modal
//        String emoji = new String(emojiByteCode, Charset.forName("UTF-8"));
        lblimg1.setText(img1);
        lblimg2.setText(img2);
        lblimg3.setText(img3);
        lblimg4.setText(img4);
        lblimg5.setText(img5);
        lblimg6.setText(img6);
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

        if (event.getSource() instanceof javafx.scene.control.Label) {
            javafx.scene.control.Label icon = (Label) event.getSource();

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
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }

        if (event.getSource() instanceof Label) {
            Label icon = (Label) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }
    }

    public void mouseClickOnAction() {
        if (txtMessage.getText().equals("finish")){
            try {
                outputStream.writeUTF(txtMessage.getText());
                outputStream.flush();
                Stage stage = (Stage) btnSend.getScene().getWindow();
                stage.close();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            outputStream.writeUTF(clientName+" :"+txtMessage.getText());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        txtMessage.clear();
    }

    public void txtMessageOnAction() {
        mouseClickOnAction();
    }

    public void btnfileOnAction() {


        Label label = new Label();
        label.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.ALICEBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        label.setStyle("-fx-font-size: 20");
        label.setText("Me :");
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Image File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            File selectedFile = fileChooser.showOpenDialog(null);
            File file;
            try {
                file = new File(selectedFile.getPath());
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(150);
                imageView.setFitHeight(150);
                HBox hBox = new HBox(12);
                hBox.setAlignment(Pos.BOTTOM_RIGHT);
                msgVboxAp.setAlignment(Pos.BOTTOM_LEFT);
                hBox.setAlignment(Pos.CENTER_RIGHT);
                hBox.getChildren().add(imageView);
                hBox.getChildren().add(label);
                Platform.runLater(() -> msgVboxAp.getChildren().addAll(hBox));
            } catch (Exception ignored) {

            }
            outputStream.writeUTF(clientName+" img " + selectedFile.getPath());
            outputStream.flush();
        } catch (IOException ignored) {

        }
    }

    public void imoji1OnAction() throws IOException {
        String imoji = clientName + " imoji" + " imoji01";
        outputStream.writeUTF(imoji);
        outputStream.flush();
    }

    public void imoji2OnAction() throws IOException {
        String imoji = clientName + " imoji" + " imoji02";
        outputStream.writeUTF(imoji);
        outputStream.flush();
    }

    public void imoji3OnAction() throws IOException {
        String imoji = clientName + " imoji" + " imoji03";
        outputStream.writeUTF(imoji);
        outputStream.flush();
    }

    public void imoji4OnAction() throws IOException {
        String imoji = clientName + " imoji" + " imoji04";
        outputStream.writeUTF(imoji);
        outputStream.flush();
    }

    public void imoji5OnAction() throws IOException {
        String imoji = clientName + " imoji" + " imoji05";
        outputStream.writeUTF(imoji);
        outputStream.flush();

    }

    public void imoji6OnAction() throws IOException {
        String imoji = clientName + " imoji" + " imoji06";
        outputStream.writeUTF(imoji);
        outputStream.flush();
    }

    public void btnLogOutClicked() throws IOException {
        outputStream.writeUTF("finish");
        outputStream.flush();
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();
    }
}
