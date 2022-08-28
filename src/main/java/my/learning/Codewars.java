package my.learning;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Codewars {
    public static boolean isPrime(int num) {
//        if (num < 2) {
//            return false;
//        }
//        for(int i = 2; i <= num / 2; i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;

//        if (num < 2) {
//            return false;
//        }
//        return !IntStream.range(2, num / 2 + 1).anyMatch(o -> num % o == 0);

        if (num == 2 || num == 3)
            return true;

        if (num <= 1 || num % 2 == 0 || num % 3 == 0)
            return false;

        for (int i = 5; i * i <= num; i += 6)
        {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }

        return true;

    }
}
