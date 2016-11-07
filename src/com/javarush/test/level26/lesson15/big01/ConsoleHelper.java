package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rolep on 07/01/16.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common", Locale.ENGLISH);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String message = "";
        try
        {
            message = reader.readLine();
            if (message.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
        }
        catch (IOException e) {}
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String input;
        while (true)
        {
            input = readString();
            if (input.length() != 3)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            else
            {
                break;
            }
        }
        input = input.toUpperCase();
        return input;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(res.getString("choose.denomination.and.count.format"));
        String[] parsedInput;
        outer:
        while (true)
        {
            String input = readString();
            parsedInput = input.split(" ");

            if (parsedInput.length != 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            for (String s : parsedInput)
            {
                try
                {
                    int i = Integer.parseInt(s);
                    if (i <= 0)
                    {
                        writeMessage(res.getString("invalid.data"));
                        continue outer;
                    }

                }
                catch (NumberFormatException e)
                {
                    writeMessage(res.getString("invalid.data"));
                    continue outer;
                }
            }
            break;
        }
        return parsedInput;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        writeMessage("1 - " + res.getString("operation.INFO"));
        writeMessage("2 - " + res.getString("operation.DEPOSIT"));
        writeMessage("3 - " + res.getString("operation.WITHDRAW"));
        writeMessage("4 - " + res.getString("operation.EXIT"));
        Operation operation = null;
        while (true)
        {
            String choice = readString();
            try
            {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(choice));
            }
            catch (NumberFormatException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return operation;
    }
    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }
}
