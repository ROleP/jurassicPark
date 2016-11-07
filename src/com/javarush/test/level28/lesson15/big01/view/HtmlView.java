package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

/**
 * Created by rolep on 15/02/16.
 */
public class HtmlView implements View
{
    private Controller controller;

    private final String filePath = "./src/"+this.getClass().getPackage().getName().replace('.','/')+"/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        String result = null;
        try
        {
            Document htmlFile = getDocument();
            Element template = htmlFile.getElementsByClass("template").first();
            Element copyTemplate = template.clone();
            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");
            Elements toDelete = htmlFile.getElementsByTag("tr");
            for (Element element : toDelete)
            {
                if (element.hasClass("vacancy"))
                {
                    if (!element.hasClass("template"))
                        element.remove();
                }
            }
            for (Vacancy vacancy : vacancies)
            {
                Element newVacancy = copyTemplate.clone();
                newVacancy.getElementsByClass("city").first().text(vacancy.getCity());
                newVacancy.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                newVacancy.getElementsByClass("salary").first().text(vacancy.getSalary());
                newVacancy.getElementsByTag("a").first().text(vacancy.getTitle()).attr("href", vacancy.getUrl());
                template.before(newVacancy.outerHtml());
            }
            result = htmlFile.html();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Some exception occurred");

        }
        return result;
    }

    private void updateFile(String fileContent)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            writer.write(fileContent,0,fileContent.length());
            writer.close();
        }
        catch (FileNotFoundException e) {}
        catch (IOException e) {}
    }

    protected Document getDocument() throws IOException
    {
        Document htmlFile = Jsoup.parse(new File(filePath), "UTF-8");
        return htmlFile;
    }
}
