package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by rolep on 26/09/15.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes type)
    {
        if (type == ImageTypes.BMP) return new BmpReader();
        if (type == ImageTypes.JPG) return new JpgReader();
        if (type == ImageTypes.PNG) return new PngReader();
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
