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
        public static void start() {
            Socket clientSocket;
            try (ServerSocket serverSocket = new ServerSocket(3031)){

                System.out.println("Server started. Waiting for client connections...");

                while (true) {
                    clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket);
                    Socket finalClientSocket = clientSocket;
                    Thread clientThread = new Thread(() -> {
                        try {
                            DataInputStream  inputStream = new DataInputStream(finalClientSocket.getInputStream());
                            int port = finalClientSocket.getPort();
                            socketList.add(finalClientSocket);

                            String incomingMessage = "";
                            System.out.println(incomingMessage);
                            while (!(incomingMessage = inputStream.readUTF()).equals("finish")) {
//                            System.out.println("Received from client " + port + ": " + incomingMessage);

                                for(Socket socket:socketList){
                                    sentMessage(socket,incomingMessage);
                                }
                            }
                            socketList.remove(finalClientSocket);
                            finalClientSocket.close();
                            System.out.println("Client disconnected: " + port);
                        } catch (IOException e) {
                            System.out.println("disconnected !");
                            System.exit(0);
                        }
                    });

                    clientThread.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void sentMessage(Socket socket,String incomingMessage) throws IOException {
        try {
                outputStream = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream.writeUTF(incomingMessage);
            outputStream.flush();
        }
    }
}
