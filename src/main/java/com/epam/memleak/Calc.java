package com.epam.memleak;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calc {
    private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int square(int i) {
        int result = i * i;
        cache.put(i, result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Calc calc = new Calc();
        while (true) {
            System.out.println("Enter a number between 1 and 100");
            int i = readUserInput(); // not shown
            System.out.println("Answer " + calc.square(i));
        }
    }

    private static int readUserInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the first number");
        // get user input for a
        return reader.nextInt();
    }

}
