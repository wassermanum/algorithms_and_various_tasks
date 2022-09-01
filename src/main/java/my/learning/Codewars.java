package my.learning;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    //SplitString
    public static String[] solution(String s) {
        char[] array = s.toCharArray();
        if (array.length % 2 != 0) {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = '_';
        }
        String[] result = new String[array.length / 2];
        for (int i = 1; i < s.length(); i += 2 ) {
            result[(i + 1) / 2] = array[i - 1] + String.valueOf(array[i]);
        }
        return result;
    }

//    static String[] solution(String s) {
//        return (s + (s.length() % 2 > 0 ? "_" : "")).split("(?<=\\G.{2})");
//    }

    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        list.removeAll(Arrays.stream(b).boxed().toList());

        return list.stream().mapToInt(x -> x).toArray();
    }

//    public static int[] arrayDiff(int[] a, int[] b) {
//        return IntStream.of(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();
//    }

    public boolean check(String sentence){
        //code
        List<Character> alphabet = IntStream
                .rangeClosed('a', 'z').mapToObj(var -> (char) var).toList();
        return alphabet.stream().allMatch(x -> sentence.contains(x.toString()));
    }

//    boolean check(final String sentence) {
//        return sentence.chars()
//                .filter(Character::isLetter)
//                .map(Character::toLowerCase)
//                .distinct()
//                .count() == 26;
//    }

    //RGB to HEX
    public static String rgb(int r, int g, int b) {
        String red = Integer.toHexString(r < 0 ? 0 : Math.min(r, 255)).toUpperCase();
        String green = Integer.toHexString(g < 0 ? 0 : Math.min(g, 255)).toUpperCase();
        String blue = Integer.toHexString(b < 0 ? 0 : Math.min(b, 255)).toUpperCase();

        return (red.length() == 1 ? "0" + red : red) +
            (green.length() == 1 ? "0" + green : green) +
            (blue.length() == 1 ? "0" + blue : blue);
    }

    public static String pigIt(String str) {
        return Arrays.stream(str.split(" ")).map(x -> {
            if (x.length() > 1 || Character.isLetter(x.charAt(0))) {
                return x.substring(1) + x.substring(0, 1) + "ay";
            }
            return x;
        }).collect(Collectors.joining(" "));
    }

//    public static String pigIt(String str) {
//        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
//    }

    public static int zeros(int n) {
        // your beatiful code here
        int result = 0;
        while (n > 24) {
            n /= 5;
            result += n;
        }
        return result;
    }

//    public static int zeros(final int n) {
//        return (n < 5) ? 0 : (n / 5) + zeros(n / 5);
//    }

    public static String camelCase(String str) {
        // your code here
        return str.trim().isEmpty() ? str : Arrays
                .stream(str.trim().split("(\\s+)"))
                .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase())
                .collect(Collectors.joining()
                );
    }

    public static int[][] getMinor(int[][] matrix, int row) {
        int[][] result = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (i != row) {
                    result[i][j] = matrix[i + 1][j];
                }
            }
        }
        return result;
    }
    public static int determinant(int[][] matrix) {
            // Your code here!
            if (matrix.length == 1) {
                return matrix[0][0];
            }

            int result = 0;
            if (matrix.length > 2) {
//                for (int i = matrix.length - 1; i >= 0; i--) {
                for (int i = 0; i < matrix.length; i++) {
                    result =
                            i % 2 == 0
                                    ? result + (determinant(getMinor(matrix, i)) * matrix[0][i])
                                    : result - (determinant(getMinor(matrix, i)) * matrix[0][i]);
                }
            }
            result += matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            return result;
    }
}
