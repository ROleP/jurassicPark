package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rolep on 08/01/16.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"deposit", Locale.ENGLISH);
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        String[] digits = ConsoleHelper.getValidTwoDigits(manipulator.getCurrencyCode());
        manipulator.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(digits[0])*Integer.parseInt(digits[1]), manipulator.getCurrencyCode()));
    }
}
