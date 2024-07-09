package com.eval.nova;
import java.util.*;
import java.util.function.Function;

public class Program {
    static List<String> takeWhile(List<String> source, Function<String, Boolean> taker) {
        // Los 1ros N elementos de source cumplen con la condicion de taker.
        // Retornar los elementos de source que cumplen la condicion de taker.
        // Usar recursion. Puedes crear funciones auxiliares si lo necesitas.
        return validate(new ArrayList<>(), source.iterator(), taker);

    }

    static List<String> validate(List<String> listResult, Iterator<String> iterator, Function<String, Boolean> taker) {
        if(!iterator.hasNext()){
            return listResult;
        }

        String value = iterator.next();

        boolean result = taker.apply(value);

        if(result) listResult.add(value);

        return validate(listResult,  iterator, taker);
    }
    //kotlin
    //concurrency api


    public static void main(String args[]) {
        List<String> source = List.of("Ana", "Abdul", "Peter");
        List<String> benchMark = List.of("Ana", "Abdul");
        List startingWithA = takeWhile(source, item -> item.startsWith("A"));

        System.out.println(benchMark.equals(startingWithA)); //--> true
    }
}