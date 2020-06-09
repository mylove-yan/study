/*******************************************************************************
 * @(#)SimpleTest.java 2020/6/8
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * 简单的stream流
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/8 8:29
 */
public class SimpleTest {
    public static void main(String[] args) {
        simple3();
    }

    public static void simple1(){
        List<String> list = Stream.of("Monkey", "Lion", "Giraffe","Lemur")
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(list);
    }

    public static void simple2(){
        String[] array = {"Monkey", "Lion", "Giraffe", "Lemur"};
        Stream<String> stream2 = Stream.of(array);
        Stream<String> stream = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        List<String> list = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");
        Stream<String> streamFromList = list.stream();
        Set<String> set = new HashSet<>(list);
        Stream<String> streamFromSet = set.stream();
    }

    public static void simple3(){
        List<String> duplicateList = Arrays.asList("a", "bb", "c", "d", "bb");

        Map<String, String> map = duplicateList
                .stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                s -> {
                                    return s.length() + " " + (new Random()).nextInt();
                                },
                                (preItem, nextItem) -> {
                                    System.out.println("item" + preItem + " curItem: " + nextItem);
                                    return nextItem;
                                }
                        )
                );

        System.out.println(map);

        List<String> givenList = Arrays.asList("a", "bb", "dd", "ccc");
        Map<Integer, Set<String>> groupList = givenList
                .stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        toSet()
                ));

        System.out.println(groupList);
    }


}
