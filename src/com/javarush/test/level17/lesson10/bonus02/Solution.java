package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/


public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        argsParser(args);

        /*
        argsParser("-c Миронов м 15/04/1990".split(" "));
        argsParser("-c Миронов м 15/03/1921".split(" "));
        argsParser("-c Миронов AASAS sadasdsa м 15/04/1990".split(" "));
        System.out.println("");
        argsParser("-i 0 4 2 1 3".split(" "));
        argsParser("-u 2 ASDASD sade3ee fdff ж 15/04/1991 0 щРЛА лофдлыв ж 12/03/1995".split(" "));
        System.out.println("");
        argsParser("-d 0".split(" "));
        argsParser("-i 0 4 2 1 3".split(" "));
        */
    }

    private static synchronized void argsParser(String[] args)
    {
        if ( args.length == 0)
        {
            //System.out.println("No arguments provided !!!");
            return;
        }
        switch (args[0])
        {
            case "-c" : createAction(args);
                break;
            case "-u" : updateAction(args);
                break;
            case "-d" : deleteAction(args);
                break;
            case "-i" : infoAction(args);
                break;
            default :
                System.out.println("Bad key option !!!\nOnly '-c', '-u', '-d', '-i' supported.");
                break;
        }
    }

    private static synchronized void createAction(String[] args)
    {
        for (int i = 1; i < args.length; i++)
        {
            try
            {
                StringBuilder name = new StringBuilder();
                while (true)
                {
                    name.append(args[i]);
                    i++;
                    if (args[i].equals("м") || args[i].equals("ж")) break;
                    name.append(" ");
                }
                Sex sex = parseSex(args[i]);
                i++;
                Date bday = parseBirthday(args[i]);
                //Adding person to list
                Person person = null;
                if (Sex.MALE.equals(sex)) person = Person.createMale(name.toString(), bday);
                else person = Person.createFemale(name.toString(), bday);
                synchronized (allPeople)
                {
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Not enough or bad arguments !!!");
                break;
            }
            catch (ParseException e)
            {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private static synchronized void updateAction(String[] args)
    {
        for (int i = 1; i < args.length; i++)
        {
            int id = 0;
            try
            {
                id = Integer.parseInt(args[i]);
                i++;
                StringBuilder name = new StringBuilder();
                while (true)
                {
                    name.append(args[i]);
                    i++;
                    if (args[i].equals("м") || args[i].equals("ж")) break;
                    name.append(" ");
                }
                Sex sex = parseSex(args[i]);
                i++;
                Date bday = parseBirthday(args[i]);
                synchronized (allPeople)
                {
                    Person person = allPeople.get(id);
                    person.setName(name.toString());
                    person.setSex(sex);
                    person.setBirthDay(bday);
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(args[i] + " is invalid ID entry !!! Omitting...");
                continue;
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Not enough or bad arguments !!!");
                break;
            }
            catch (IndexOutOfBoundsException e)
            {
                //System.out.println("No person with id " + id + " !!!");
                continue;
            }
            catch (ParseException e)
            {
                System.out.println(e.getMessage());
                continue;
            }
            catch (NullPointerException e)
            {
                //System.out.println("No person with id " + id + " !!!");
                continue;
            }
        }
    }

    private static synchronized void deleteAction(String[] args)
    {
        List<Integer> idList = new ArrayList<Integer>();
        for (int i = 1; i < args.length; i++)
        {
            try
            {
                idList.add(Integer.parseInt(args[i]));
            }
            catch (NumberFormatException e)
            {
                System.out.println(args[i] + " is invalid ID entry !!! Omitting...");
                continue;
            }
        }
        synchronized (allPeople)
        {
            for (Integer id : idList)
            {
                try
                {
                    //allPeople.set(id, null);
                    allPeople.remove(id);
                    //Person person = allPeople.get(id);
                    //person.setName(null);
                    //person.setSex(null);
                    //person.setBirthDay(null);
                }
                catch (IndexOutOfBoundsException e)
                {
                    //System.out.println("No person with id " + id + " !!!");
                    continue;
                }
            }
        }
    }

    private static synchronized void infoAction(String[] args)
    {
        List<Integer> idList = new ArrayList<Integer>();
        for (int i = 1; i < args.length; i++)
        {
            try
            {
                idList.add(Integer.parseInt(args[i]));
            }
            catch (NumberFormatException e)
            {
                System.out.println(args[i] + " is invalid ID entry !!! Omitting...");
                continue;
            }
        }
        synchronized (allPeople)
        {
            for (Integer id : idList)
            {
                try
                {
                    Person person = allPeople.get(id);
                    if (person == null)
                    {
                        //System.out.println("No person with id " + id + " !!!");
                        continue;
                    }
                    System.out.println(person.getName() + " " + parseSex(person.getSex()) + " " + parseBirthday(person.getBirthDay()));
                }
                catch (IndexOutOfBoundsException e)
                {
                    //System.out.println("No person with id " + id + " !!!");
                    continue;
                }
                catch (NullPointerException e)
                {
                    //System.out.println("No person with id " + id + " !!!");
                    continue;
                }
            }
        }
    }

    private static Sex parseSex(String sex)
    {
        if (sex.equals("м")) return Sex.MALE;
        else return Sex.FEMALE;
    }

    private static String parseSex(Sex sex)
    {
        if (sex.equals(Sex.MALE)) return "м";
        else return "ж";
    }

    private static String parseBirthday(Date bday)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return sdf.format(bday);
    }

    private static Date parseBirthday(String bday) throws ParseException
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            return sdf.parse(bday);
        }
        catch (ParseException e)
        {
            throw new ParseException("Bad date " + bday + " !!!", e.getErrorOffset());
        }
    }
}

/*
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createFemale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        try
        {
            if (args[0].equals("-c"))
            {
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i = i + 3)
                    {
                        Person person = null;
                        String name = args[i];
                        String sex = args[i + 1];
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
                        Date date = format.parse(args[i + 2]);
                        person = sex.equals("м") ?  Person.createMale(name, date) : Person.createFemale(name, date);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
            }
            if (args[0].equals("-u"))
            {
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i = i + 4)
                    {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
                        Date date = format.parse(args[i + 3]);
                        for (int j = 0; j < allPeople.size(); j++)
                        {
                            if (id == j)
                            {

                                allPeople.get(j).setName(name);
                                allPeople.get(j).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                                allPeople.get(j).setBirthDay(date);

                            }
                        }
                    }
                }
            }
            if (args[0].equals("-d"))
            {
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i++)
                    {

                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                    }
                }
            }
            if (args[0].equals("-i"))
            {
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i++)
                    {
                        int id = Integer.parseInt(args[i]);
                        System.out.print(allPeople.get(id).getName() + " ");
                        System.out.print(allPeople.get(id).getSex().equals(Sex.MALE) ? "м " : "ж ");
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(format.format(allPeople.get(id).getBirthDay()));
                    }
                }

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
*/