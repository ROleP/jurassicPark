package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by rolep on 07/01/16.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        int currentAmount = 0;
        if (denominations.containsKey(denomination))
            currentAmount = denominations.get(denomination);
        denominations.put(denomination, count + currentAmount);
    }

    public int getTotalAmount()
    {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            totalAmount += entry.getKey() * entry.getValue();
        }
        return totalAmount;
    }

    public boolean hasMoney()
    {
        for (Integer value : denominations.values())
        {
            if (value > 0) return true;
        }
        return false;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        if (expectedAmount <= getTotalAmount()) return true;
        return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int notYetCashedAmount = expectedAmount;

        TreeMap<Integer, Integer> copy = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });
        copy.putAll(denominations);
        TreeMap<Integer, Integer> withdraw = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });
        for (Map.Entry<Integer, Integer> entry : copy.entrySet())
        {
            int amount = 0;
            while (entry.getKey() <= notYetCashedAmount)
            {
                if (amount <= entry.getValue())
                {
                    amount++;
                    notYetCashedAmount -= entry.getKey();
                }
                else break;
            }
            if (amount > 0)
            {
                withdraw.put(entry.getKey(), amount);
                copy.put(entry.getKey(), entry.getValue() - amount);
            }
        }
        if (notYetCashedAmount != 0)
            throw new NotEnoughMoneyException();
        for (Map.Entry<Integer, Integer> entry : withdraw.entrySet())
        {
            ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
        }
        ConsoleHelper.writeMessage("Transaction successfull!");
        /*
        Map<Integer, Integer> copy = new HashMap<>(denominations);
        ArrayList<Integer> bills = new ArrayList<>();
        Collections.addAll(copy.keySet());
        Collections.sort(bills);
        Collections.reverse(bills);
        Map<Integer, Integer> withdraw = new HashMap<>();
        for (Integer bill : bills)
        {
            int amount = 0;
            while (bill <= notYetCashedAmount)
            {
                if (amount <= copy.get(bill))
                {
                    amount++;
                    notYetCashedAmount -= bill;
                }
                else break;
            }
            withdraw.put(bill, amount);
            copy.put(bill, copy.get(bill) - amount);
        }
        if (notYetCashedAmount != 0)
            throw new NotEnoughMoneyException();
        for (Integer bill : bills)
        {
            if (withdraw.containsKey(bill))
            {
                ConsoleHelper.writeMessage(String.format("\t%d - %d", bill, withdraw.get(bill)));
            }
        }
        ConsoleHelper.writeMessage("Transaction successfull!");
        */
        denominations.putAll(copy);
        return withdraw;
    }
}
