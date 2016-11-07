package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolep on 16/02/16.
 */
public class MoikrugStrategy implements Strategy
{
        private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        Document doc;
        try
        {
            for (int i = 1; ; i++)
            {
                doc = getDocument(searchString, i);
                Elements elements = doc.getElementsByClass("job");
                for (Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByClass("title").first().attr("title"));
                    Element city = element.getElementsByClass("location").first();
                    if (city != null)
                        city = city.getElementsByTag("a").first();
                    String cityName = null;
                    if (city != null)
                        cityName = city.text();
                    if (cityName == null)
                        cityName = searchString;
                    vacancy.setCity(cityName);
                    vacancy.setCompanyName(element.getElementsByClass("company_name").first().getElementsByTag("a").first().text());
                    String salary = element.getElementsByClass("salary").first().text();
                    if (salary == null)
                        salary = "";
                    vacancy.setSalary(salary);
                    vacancy.setSiteName(doc.title());
                    vacancy.setUrl("https://moikrug.ru" + element.getElementsByClass("job_icon").first().attr("href"));
                    vacancies.add(vacancy);
                }
                if (elements.size() == 0) break;
            }
        }
        catch (IOException e) {}
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        Document doc = doc = Jsoup.connect(String.format(URL_FORMAT, page, searchString)).userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0").referrer("https://moikrug.ru").get();
        return doc;
    }
}
