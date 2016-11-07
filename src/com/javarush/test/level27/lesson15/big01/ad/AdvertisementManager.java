package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rolep on 24/01/16.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        if (storage.list().size() == 0)
            throw new NoVideoAvailableException();
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                long result = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (result == 0)
                {
                    result = (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration()) - (o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
                return (int) result;
            }
        });
/*
        class RecursionHolder
        {
            List<Advertisement> getTargetAdsRecursion(List<Advertisement> list, int thisTurnAdIndex)
            {
                if (list)


                    if (index)
                    {

                        getTargetAdsRecursion(list);
                    }

                for (int i = thisTurnAdIndex + 1; i < storage.list().size() - 1; i++)
                {
                    
                }

            }
        }
*/
        boolean show = false;
        for (Advertisement ad : storage.list())
        {
            if (ad.getDuration() <= timeSeconds)
            {
                ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", " + (ad.getAmountPerOneDisplaying()*1000/ad.getDuration()));
                show = true;
                timeSeconds -= ad.getDuration();
                ad.revalidate();
            }
        }
        if (!show)
            throw new NoVideoAvailableException();
    }
}
