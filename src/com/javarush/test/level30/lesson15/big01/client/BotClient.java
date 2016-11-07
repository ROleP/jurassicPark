package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by rolep on 3/10/16.
 */
public class BotClient extends Client {

    ///Class BotSocketThread begins
    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] parts = message.split(": ",2);
            if (parts.length != 2) {
                return;
            }
            String userName = parts[0].trim();
            String messageText = parts[1];
            String customResponse = null;
            switch (messageText) {
                case "дата":
                    customResponse = new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime());
                    break;
                case "день":
                    customResponse = new SimpleDateFormat("d").format(Calendar.getInstance().getTime());
                    break;
                case "месяц":
                    customResponse = new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime());
                    break;
                case "год":
                    customResponse = new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime());
                    break;
                case "время":
                    customResponse = new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime());
                    break;
                case "минуты":
                    customResponse = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
                    break;
                case "час":
                    customResponse = new SimpleDateFormat("H").format(Calendar.getInstance().getTime());
                    break;
                case "секунды":
                    customResponse = new SimpleDateFormat("s").format(Calendar.getInstance().getTime());
                    break;
                default:
                    return;
            }
            sendTextMessage("Информация для " + userName + ": " + customResponse);
        }
    }
    ///Class BotSocketThread ends


    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("%s_bot_%02d", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()),(int)(Math.random()*100));
    }

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }
}
