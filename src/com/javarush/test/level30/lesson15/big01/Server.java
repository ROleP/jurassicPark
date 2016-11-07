package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rolep on 3/6/16.
 */
public class Server {
    /// Handler class starts
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            for(;;) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response = connection.receive();

                if (response.getType() == MessageType.USER_NAME) {
                    String userName = response.getData();
                    if (userName == null || userName.trim().length() == 0 || connectionMap.containsKey(userName)) {
                        continue;
                    }
                    connectionMap.put(userName, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return userName;
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws
IOException {
            for (String s : connectionMap.keySet()) {
                if (!s.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws
IOException, ClassNotFoundException {
            while(true) {
                Message incoming = connection.receive();
                if (incoming.getType() == MessageType.TEXT) {
                    Message resendToAll = new Message(MessageType.TEXT, String.format("%s: %s", userName, incoming.getData()));
                    sendBroadcastMessage(resendToAll);
                }
                else {
                    ConsoleHelper.writeMessage("Полученное сообщение не является текстом.");
                }
            }
        }

        @Override
        public void run() {
            try {
                Connection connection = null;
                String newUser = null;
                try {
                    ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress() + ".");
                    connection = new Connection(socket);
                    newUser = serverHandshake(connection);
                    sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser));
                    sendListOfUsers(connection, newUser);
                    serverMainLoop(connection, newUser);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                } catch (ClassNotFoundException e) {
                    ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                } finally {
                    connection.close();
                    if (newUser != null) {
                        connectionMap.remove(newUser);
                        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUser));
                    }
                    ConsoleHelper.writeMessage("Соединение с удаленным адресом " + connection.getRemoteSocketAddress() + " закрыто.");
                }
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при закрытии соединения.");
            }
        }
    }
    ///Handler class ends

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение пользователю " + entry.getKey() + ".");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите номер порта:");
        int serverPort = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(serverPort);
        ConsoleHelper.writeMessage("Чат-Сервер запущен!!!");
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (Exception e) {
            serverSocket.close();
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}
