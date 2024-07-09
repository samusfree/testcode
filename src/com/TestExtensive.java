package com;

import java.util.Arrays;
import java.util.List;

public class TestExtensive {

    public static void main(String[] args) {
        String search = "god";
        List<String> list = Arrays.asList("dog", "book");

        System.out.println(runDogBookProblem(search, list));
    }

    private static boolean runDogBookProblem(String searchString, List<String> dictionaryList) {
        String look = sortString(searchString.toLowerCase());
        return dictionaryList.stream().filter(x -> look.equals(sortString(x.toLowerCase()))).findFirst().isPresent();
    }

    public static String sortString(String value) {
        char[] chars = value.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
