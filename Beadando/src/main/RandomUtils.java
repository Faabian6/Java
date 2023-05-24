package main;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    //véletlenszerű számot generáltat az adott sebzesHatar határok között
    public static int nextInt(int sebzesHatar) {
        return random.nextInt(sebzesHatar) + 1;
    }
}

