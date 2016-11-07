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
 * Created by rolep on 05/02/16.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        Document doc;
        try
        {
            for (int i = 0; ; i++)
            {
                doc = getDocument(searchString, i);
                Elements elements = doc.select("[data-qa=\"vacancy-serp__vacancy\"]");
                for (Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.select("[data-qa=\"vacancy-serp__vacancy-title\"]").text());
                    vacancy.setCity(element.select("[data-qa=\"vacancy-serp__vacancy-address\"]").text());
                    vacancy.setCompanyName(element.select("[data-qa=\"vacancy-serp__vacancy-employer\"]").text());
                    vacancy.setSalary(element.select("[data-qa=\"vacancy-serp__vacancy-compensation\"]").text());
                    vacancy.setSiteName(doc.title());
                    vacancy.setUrl(element.select("[data-qa=\"vacancy-serp__vacancy-title\"]").attr("href"));
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
        Document doc = doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0").referrer("http://hh.ua").get();
        return doc;
    }
}
