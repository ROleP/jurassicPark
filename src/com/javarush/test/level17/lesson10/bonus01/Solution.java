package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/
/*
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                //start here - начни тут
                String abc = reader.readLine();
                if ("exit".equals(abc)) break;
                args = abc.split(" ");
                switch (args[0])
                {
                    case "-c":
                        synchronized (allPeople)
                        {
                            int nameEnd = 1;
                            StringBuilder name = new StringBuilder(args[nameEnd]);
                            while (true)
                            {
                                if (args[nameEnd + 1].equals("М"))
                                {
                                    allPeople.add(Person.createMale(name.toString(), parseDate(args[nameEnd + 2])));
                                    System.out.println(allPeople.size() - 1);
                                    break;
                                }
                                else if (args[nameEnd + 1].equals("Ж"))
                                {
                                    allPeople.add(Person.createFemale(name.toString(), parseDate(args[nameEnd + 2])));
                                    System.out.println(allPeople.size() - 1);
                                    break;
                                }
                                nameEnd++;
                                name.append(" ").append(args[nameEnd]);
                            }
                        }
                        break;
                    case "-u":
                        synchronized (allPeople)
                        {
                            Person person = allPeople.get(Integer.parseInt(args[1]));
                            int nameEnd = 2;
                            StringBuilder name = new StringBuilder(args[nameEnd]);
                            while (true)
                            {

                                if (args[nameEnd + 1].equals("М"))
                                {
                                    person.setSex(Sex.MALE);
                                    break;
                                }
                                else if (args[nameEnd + 1].equals("Ж"))
                                {
                                    person.setSex(Sex.FEMALE);
                                    break;
                                }
                                nameEnd++;
                                name.append(" ").append(args[nameEnd]);
                            }
                            person.setName(name.toString());
                            person.setBirthDay(parseDate(args[nameEnd + 2]));
                        }
                        break;
                    case "-d":
                        synchronized (allPeople)
                        {
                            allPeople.set(Integer.parseInt(args[1]), null);
                        }
                        break;
                    case "-i":
                        synchronized (allPeople)
                        {
                            Person person = allPeople.get(Integer.parseInt(args[1]));
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            String sex = person.getSex().equals(Sex.MALE) ? "М" : "Ж";
                            System.out.println(person.getName() + " " + sex + " " + sdf.format(person.getBirthDay()));
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {}
    }

        public static Date parseDate(String s)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date parsedDate = null;
            try
            {
                parsedDate = sdf.parse(s);
            } catch (ParseException e) { System.out.println("Bad date format !!!"); }
            return parsedDate;
        }

}
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Params params = argsParser.parse(args);
        if (args[0].equals("-c"))
        {
            createHuman(params);
        }
        else if (args[0].equals("-u"))
        {
            updateHuman(params);
        }
        else if (args[0].equals("-d"))
        {
            deleteHuman(params);
        }
        else if (args[0].equals("-i"))
        {
            printHuman(params);
        }
    }

    public static void createHuman(Params params)
    {
        Person person;
        if (params.gender == Sex.MALE)
        {
            person = Person.createMale(params.name, params.birthday);
        }
        else
        {
            person = Person.createFemale(params.name, params.birthday);
        }
        allPeople.add(person);
        System.out.println(allPeople.size() - 1);
    }

    public static void updateHuman(Params params)
    {
        Person person = allPeople.get(params.id);
        person.setName(params.name);
        person.setSex(params.gender);
        person.setBirthDay(params.birthday);
        allPeople.set(params.id, person);
    }

    public static void deleteHuman(Params params)
    {
        allPeople.remove(params.id);
    }

    public static void printHuman(Params params)
    {
        Person p = allPeople.get(params.id);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(String.format
                (
                        "%s %c %s", p.getName(), p.getSex() == Sex.MALE ? 'м' : 'ж', format.format(p.getBirthDay())
                ));
    }

    public static class Params
    {
        Integer id;
        String name;
        Sex gender;
        Date birthday;
    }

    public static class argsParser {
        private static Integer parseId(String id)
        {
            return Integer.parseInt(id);
        }

        private static String parseName(String name)
        {
            return name;
        }

        private static Sex parseGender(String gender)
        {
            if (gender.equals("м"))
            {
                return Sex.MALE;
            }
            return Sex.FEMALE;
        }

        private static Date parseDate(String date)
        {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date result = null;
            try
            {
                result = fmt.parse(date);
            }
            catch (Exception e)
            {

            }
            return result;
        }

        public static Params parse(String[] params)
        {
            Params result = new Params();
            if (params[0].equals("-d") || params[0].equals("-i") || params[0].equals("-u"))
            {
                result.id = parseId(params[1]);
            }
            int index = 0;
            if (params[0].equals("-c"))
            {
                index = 1;
            }
            else if (params[0].equals("-u"))
            {
                index = 2;
            }
            if (index != 0)
            {
                result.name = parseName(params[index++]);
                result.gender = parseGender(params[index++]);
                result.birthday = parseDate(params[index++]);
            }
            return result;
        }
    }
}
