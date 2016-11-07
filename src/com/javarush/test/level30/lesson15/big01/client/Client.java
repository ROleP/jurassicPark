package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by rolep on 3/10/16.
 */
public class Client {

    ///Class SocketThread begins
    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник " + userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while(true) {
                Message receivedMessage = connection.receive();
                if (receivedMessage.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }
                else if (receivedMessage.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message receivedMessage = connection.receive();
                if (receivedMessage.getType() == MessageType.TEXT) {
                    processIncomingMessage(receivedMessage.getData());
                }
                else if (receivedMessage.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(receivedMessage.getData());
                }
                else if (receivedMessage.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(receivedMessage.getData());
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        @Override
        public void run() {
            try {
                String serverAddress = getServerAddress();
                int serverPort = getServerPort();
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
    ///Class SocketThread ends

    private volatile boolean clientConnected = false;

    protected Connection connection;

    protected String getServerAddress() {

        ///Implementation of valid ip address being provided.
        ///Used IpAddress class exception in calling method

        while (true) {
            ConsoleHelper.writeMessage("Укажите адрес чат-сервера:");
            String address = ConsoleHelper.readString();
            try {
                if (address == null || address.isEmpty()) {
                    continue;
                }

                if (address.equals("localhost")) {
                    return address;
                }

                String[] parts = address.split("\\.");
                if (parts.length != 4) {
                    continue;
                }

                for (String s : parts) {
                    int i = Integer.parseInt(s);
                    if ((i < 0) || (i > 255)) {
                        continue;
                    }
                }
                if (address.endsWith(".")) {
                    continue;
                }

                return address;
            } catch (NumberFormatException nfe) {
                continue;
            }
        }
        /*
        ConsoleHelper.writeMessage("Укажите адрес чат-сервера:");
        return ConsoleHelper.readString();
        */
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Укажите порт чат-сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        while(true) {
            ConsoleHelper.writeMessage("Укажите имя пользователя:");
            String userName = ConsoleHelper.readString();
            if (userName == null || userName.isEmpty()) {
                continue;
            }
            return userName;
        }
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e) {
            ConsoleHelper.writeMessage("Возникла ошибка при передаче сообщения: " + e.getMessage() + "\nСоединение разорвано.");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread secondaryThread = getSocketThread();
        secondaryThread.setDaemon(true);
        secondaryThread.start();

        try {
            synchronized (this) {
                this.wait();
            }

        }
        catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Во время ожидания возникла ошибка: " + e.getMessage());
            return;
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        }
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while(clientConnected) {
            String input = ConsoleHelper.readString();
            if (input.equals("exit")) {
                break;
            }
            if (shouldSentTextFromConsole()) {
                sendTextMessage(input);
            }
        }

        try {
            connection.close();
        }
        catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при закрытии соединения.");
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
