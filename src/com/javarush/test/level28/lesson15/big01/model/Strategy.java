package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by rolep on 05/02/16.
 */
public interface Strategy
{
    public List<Vacancy> getVacancies(String searchString);
}
