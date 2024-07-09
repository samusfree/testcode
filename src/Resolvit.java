// package whatever; // don't place package name!
/*
Write a program that parses a sentence and replaces each word with the following:
1) The first letter of the word
2) The number of distinct characters between first and last character
3) The last letter of the word.
For example, Smooth would become S3h.
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*/
//Creativity is thinking-up new things. Innovation is doing new things!
//expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!

//Creativity is thinking---up-next new things. Innovation is doing new things!
//expected: C6y is t4g---up-n2t n1w t4s. I6n is d3g n1w t4s!

//Hello my Friend. Cardona and you? Amazing:::do you think?
// expected:  H2o my F4d. C5a a1d y1u? A5g:::do y1u t3k?

//That is amazing***or***what do you think?
// expected: T2t is a5g***or***w2t do y1u t3k?

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Resolvit {
    public static void main(String[] args) {
        String word = "That is amazing***or***what do you think?";
        System.out.println(applyAlgorithm(word));
    }

    public static String applyAlgorithm(String sentence) {
        //first break the word by spaces
        String [] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            //for every word apply parse
            sb.append(parse(words[i]));
            //add the space
            if(i != (words.length -1)) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //method to parse the word and break the word if exists special characters
    //and apply the algorithm
    public static String parse(String input) {
        if(Objects.isNull(input) || input.length() < 3) {
            return input;
        }

        if(!hasSpecialCharacters(input)) {
            return parseCleanWord(input);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            if(Character.isLetterOrDigit(input.charAt(i))) {
               temp.append(input.charAt(i));
            } else {
                if(!temp.isEmpty()) {
                    sb.append(parse(temp.toString()));
                    temp = new StringBuilder();
                }
                sb.append(input.charAt(i));
            }
        }

        if(!temp.isEmpty()) {
            sb.append(parse(temp.toString()));
        }

        return sb.toString();
    }

    public static boolean hasSpecialCharacters(String input) {
        for(int i = 0; i < input.length(); i++) {
            if(!Character.isLetterOrDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //method to apply the algorithm to words without special characters
    public static String parseCleanWord(String input) {
        Set<Character> characters = new HashSet<>();
        for(int i = 1; i < input.length() -1; i++) {
            characters.add(input.charAt(i));
        }
        return input.charAt(0) + "" + characters.size() + input.charAt(input.length()-1);
    }
}
