package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rolep on 12/01/16.
 */
public class LoginCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login", Locale.ENGLISH);
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String givenCardNumber = ConsoleHelper.readString();
            String givenCardPin = ConsoleHelper.readString();
            try
            {
                if (givenCardNumber.length() != 12 || givenCardPin.length() != 4)
                    throw new IllegalArgumentException();
                for (int i = 0; i < givenCardNumber.length(); i++)
                {
                    if (!Character.isDigit(givenCardNumber.charAt(i)))
                        throw new IllegalArgumentException();
                }
                for (int i = 0; i < givenCardPin.length(); i++)
                {
                    if (!Character.isDigit(givenCardPin.charAt(i)))
                        throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException e)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (validCreditCards.getString(givenCardNumber).equals(givenCardPin))
            {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), givenCardNumber));
                break;
            }
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), givenCardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }
        }
    }
}
