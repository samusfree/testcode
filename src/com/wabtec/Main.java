package com.wabtec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {

    private final String[] testInput = new String[] {
            "each word in this sentence occurs once",
            "this is test input for the function for which we want to test the input",
            "one two two three three three four four four four five five five five five six six six six six six seven seven seven seven seven seven seven eight eight eight eight eight eight eight eight",
            "one Two two Three THREE three four four four four five five five five five six six six six six six seven seven seven seven seven seven seven eight eight eight eight eight eight eight eight",
    };

    public static void main(String[] args) {
        Main main = new Main();
        for (String input: main.testInput) {
            main.printWordCounts(input);
            main.printOdddWords(input);
        }

        main.fizzBuzz(50);
    }

    /**
     * For the given input string, output the number of occurrences of each unique word in the sentence.
     * For example, given the input of "an apple and an orange", the output of this function should be
     *   an: 2
     *   apple: 1
     *   and: 1
     *   orange:1
     **/
    public void printWordCounts(String input) {
        Map<String, Integer> wordsAndCount = new HashMap<>();
        String [] words = input.split(" ");
        for(String word: words) {
            String wordNotCase = word.toLowerCase();
            if(Objects.nonNull(wordsAndCount.get(wordNotCase))) {
                wordsAndCount.put(wordNotCase, wordsAndCount.get(wordNotCase) + 1);
            } else {
                wordsAndCount.put(wordNotCase, 1);
            }
        }

        wordsAndCount.entrySet().forEach((entry -> System.out.println(entry.getKey() + ": " + entry.getValue())));
        System.out.println("============ End printWordCounts ============");
    }

    /**
     * For the given input string, output the words that occur an odd number of times.  For example,
     * given the input of "one two two three three three", the output of this function should be
     *   one
     *   three
     *   The word two occurs twice, so it is excluded
     */
    public void printOdddWords(String input) {
        Set<String> setWords = new HashSet<>();
        String [] words = input.split(" ");
        for(String word: words) {
            String wordNotCase = word.toLowerCase();
            if(setWords.contains(wordNotCase)) {
                setWords.remove(wordNotCase);
            } else {
                setWords.add(wordNotCase);
            }
        }
        setWords.forEach(System.out::println);
        System.out.println("============ End printOdddWords ============");
    }

    /**
     * Print integers one-to-limit, but print “Fizz” if an integer is divisible by three,
     * “Buzz” if an integer is divisible by five, and “FizzBuzz” if an integer is divisible
     * by both three and five.
     */
    public void fizzBuzz(int limit) {
        for(int i = 1; i<= limit; i++) {
            if(i % 3 == 0) {
                System.out.print("Fizz");
            }
            if(i % 5 == 0) {
                System.out.print("Buzz");
            }
            if(i % 3 != 0 && i % 5 != 0) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}