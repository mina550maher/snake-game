package util;

import java.util.Random;

public class IntRandomGen {
    private static final Random random = new Random();

    public static int next(int bound) {
        return random.nextInt(bound);
    }
}
