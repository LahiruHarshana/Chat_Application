package lk.ijse.chatApplication.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.charset.Charset;
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
}
