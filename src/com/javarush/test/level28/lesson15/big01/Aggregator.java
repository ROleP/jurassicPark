package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;

/**
 * Created by rolep on 05/02/16.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HtmlView testView = new HtmlView();
        Model testModel = new Model(testView, new Provider(new HHStrategy()), new Provider(new MoikrugStrategy()));
        Controller testController = new Controller(testModel);
        testView.setController(testController);
        testView.userCitySelectEmulationMethod();
    }
}
