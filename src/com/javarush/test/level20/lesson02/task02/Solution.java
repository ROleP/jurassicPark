package com.javarush.test.level20.lesson02.task02;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            user1.setFirstName("Alex");
            user1.setLastName("Ilyenko");
            user1.setBirthDate(new Date(1989, 3, 15));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Bart");
            user2.setBirthDate(new Date(1989, 3, 15));
            user2.setCountry(User.Country.OTHER);

            User user3 = new User();
            user3.setLastName("Jolie");
            user3.setMale(false);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.users.get(0).getCountry().getDisplayedName());
            System.out.println(loadedObject.users.get(0).getCountry().getDisplayedName());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            for (User user : users)
            {
                if (user.getFirstName() != null) writer.print(user.getFirstName());
                else writer.print("-");
                if (user.getLastName() != null) writer.print(" "+user.getLastName());
                else writer.print(" -");
                if (user.getBirthDate() != null) writer.print(" "+user.getBirthDate().getTime());
                else writer.print(" -");
                writer.print(" "+user.isMale());
                if (user.getCountry() != null) writer.println(" "+user.getCountry());
                else writer.println(" -");
                writer.flush();
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(reader.readLine());
            while (size > 0)
            {
                String[] userData = reader.readLine().split(" ");
                for (String s : userData)
                {
                    System.out.println(s);
                }
                User user = new User();
                if (!userData[0].equals("-")) user.setFirstName(userData[0]);
                if (!userData[1].equals("-")) user.setLastName(userData[1]);
                if (!userData[2].equals("-"))
                {
                    Date date = new Date();
                    date.setTime(Long.parseLong(userData[2]));
                    user.setBirthDate(date);
                }
                user.setMale(Boolean.parseBoolean(userData[3]));
                if (!userData[0].equals("-"))
                {
                    if (userData[4].equals("UKRAINE"))
                        user.setCountry(User.Country.UKRAINE);
                    else if (userData[4].equals("RUSSIA"))
                        user.setCountry(User.Country.RUSSIA);
                    else user.setCountry(User.Country.OTHER);
                }
                this.users.add(user);
                size--;
            }
            reader.close();
        }
    }
}
