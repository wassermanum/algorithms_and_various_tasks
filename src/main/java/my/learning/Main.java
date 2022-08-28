package my.learning;

import static my.learning.Codewars.*;
public class Main {
    public static void main(String[] args) {

//        System.out.println(Codewars.isPrime(7));
//        System.out.println(Codewars.isPrime(4));
//        System.out.println(Codewars.isPrime(13));
//        System.out.println(Codewars.isPrime(7));
//        System.out.println("Hello world!");
//        System.out.println(dontGiveMeFive(3, 8));

        char[] chars = {'a', 'b', 'd'};
        System.out.println(Character.codePointAt(chars, 0));
        System.out.println(Character.codePointAt(chars, 1));
        System.out.println(Character.codePointAt(chars, 2));
        System.out.println((char) ('a' + 1));
        System.out.println('d' - 'a');
    }
}