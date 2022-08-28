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

    public static int rowSumOddNumbers(int n) {
        int lastTermInRow = n*n + n - 1;
        int firstTermInRow = lastTermInRow - 2 * (n - 1);
        return (firstTermInRow + lastTermInRow) / 2 * n;
    }

    public static int dontGiveMeFive(int start, int end)
    {
        return (int) IntStream.rangeClosed(start, end).boxed().filter(o -> !o.toString().contains("5")).count();
    }

    public static char findMissingLetter(char[] array)
    {
        for (int i = 1; i < array.length; i++) {
            int currentCharCodepoint = Character.codePointAt(array, i);
            int previousCharCodepoint = Character.codePointAt(array, i - 1);
            if (currentCharCodepoint - previousCharCodepoint > 1) {
                return Character.toString(currentCharCodepoint - 1).charAt(0);
            }
        }
        return ' ';
    }
}
