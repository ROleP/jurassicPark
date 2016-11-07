package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static
    {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    // ТЕСТОВЫЙ MAIN
    /*
    public static void main(String [] args)
    {
        class iData implements IncomeData
        {
            String countryCode = "UA";
            String company = "JavaRush Ltd.";
            String firstName = "Ivan";
            String lastName = "Ivanov";
            int phoneCode = 38;
            int numPhone = 501234567;

            @Override
            public String getCountryCode()
            {
                return countryCode;
            }

            @Override
            public String getCompany()
            {
                return company;
            }

            @Override
            public String getContactFirstName()
            {
                return firstName;
            }

            @Override
            public String getContactLastName()
            {
                return lastName;
            }

            @Override
            public int getCountryPhoneCode()
            {
                return phoneCode;
            }

            @Override
            public int getPhoneNumber()
            {
                return numPhone;
            }
        }

        IncomeDataAdapter ap = new IncomeDataAdapter(new iData());
        System.out.println(ap.getName());
        System.out.println(ap.getCompanyName());
        System.out.println(ap.getCountryName());
        System.out.println(ap.getPhoneNumber());
    }
    */




    /*
    static
    {
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada", "CA");
    }
    */

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData data;

        public IncomeDataAdapter(IncomeData data)
        {
            this.data = data;
        }

        @Override
        public String getName()
        {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            StringBuilder num = new StringBuilder();
            num.append(data.getPhoneNumber());
            while (num.length()<10) num.insert(0,"0");
            num.insert(0,"(");
            num.insert(4,")");
            num.insert(8,"-");
            num.insert(11,"-");
            num.insert(0,data.getCountryPhoneCode());
            num.insert(0,"+");
            return num.toString();
        }

        @Override
        public String getCompanyName()
        {
            return data.getCompany();
        }

        @Override
        public String getCountryName()
        {
            //String code = data.getCountryCode();
            //String country = code;
            //for (String s : countries.keySet())
            //{
            //    System.out.println(s);
            //    if (code.equals(s)) country = countries.get(s);
            //}

            return countries.get(data.getCountryCode());
        }

        /*
        private Customer customer;
        private Contact contact;
        public IncomeDataAdapter(Customer customer, Contact contact)
        {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            return countries.get(customer.getCountryName());
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String fullName = contact.getName();
            return fullName.substring(fullName.indexOf(",")+2);
        }

        @Override
        public String getContactLastName()
        {
            String fullName = contact.getName();
            return fullName.substring(0,fullName.indexOf(","));
        }

        @Override
        public int getCountryPhoneCode()
        {
            String number = contact.getPhoneNumber();
            String code = number.split("[+(]")[1];
            return Integer.parseInt(code);
        }

        @Override
        public int getPhoneNumber()
        {
            String number = contact.getPhoneNumber();
            StringBuilder num = new StringBuilder();
            for (int i = number.indexOf("(")+1; i < number.length(); i++)
            {
                if (Character.isDigit(number.charAt(i))) num.append(number.charAt(i));
            }
            while (num.length()<10) num.append(0);
            return Integer.parseInt(num.toString());
        }
        */
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}