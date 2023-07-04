package lk.ijse.chatApplication.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private static final List<Socket> socketList = new ArrayList<>();
    static DataOutputStream outputStream = null;

    public static void start() {
    }
}
