package supernova.battledemo.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    public static final int nextInt()
    {
        return random.nextInt();
    }

    public static final int nextInt(int max)
    {
        return random.nextInt(max);
    }

    public static final int nextInt(int min, int max)
    {
        final int width = max - min;
        return random.nextInt(width) - (width / 2);
    }

}