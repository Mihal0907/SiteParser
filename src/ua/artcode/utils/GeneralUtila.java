package ua.artcode.utils;

import java.util.List;

public class GeneralUtila {

    public static void clearSout(List<?> list){
        list.forEach(System.out::println);
    }
}
