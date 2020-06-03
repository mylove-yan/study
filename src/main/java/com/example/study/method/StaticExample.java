/*******************************************************************************
 * @(#)StaticExample.java 2020/6/2
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.method;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 静态方法引用
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/2 19:22
 */
public class StaticExample {
    /**
     * 无参数有返回值
     * @return
     */
    public static String put() {
        System.out.println("put method");
        return "hello";
    }

    /**
     * 有参数无返回值
     * @param size
     */
    public static void con(String size) {
        System.out.println("size: " + size);
    }

    /**
     * 带有一个参数一个返回值
     * @param str
     * @return
     */
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * 带有两个参数一个返回值
     * @param s1
     * @param s2
     * @return
     */
    public static Integer len(String s1, String s2) {
        return s1.length() + s2.length();
    }

    public static void main(String[] args) {
        /**
         * 无参数有返回值
         */
        //lambda表达式的写法
        Supplier<String> stringSupplier= ()-> StaticExample.put();
        System.out.println(stringSupplier.get());

        //方法引用
        Supplier<String> stringSupplier2 = StaticExample::put;
        System.out.println(stringSupplier.get());

        /**
         *  有参数无返回值
         */
        //lambda表达式的写法
        Consumer<String> consumer = (x)-> StaticExample.con(x);
        consumer.accept("100");
        //方法引用
        Consumer<String> consumer2= StaticExample::con;
        consumer.accept("100");

        /**
         * 有1个参数有一个返回值
         */
        //lambda表达式的写法
        Function<String,String> function = (x)-> StaticExample.toUpperCase(x);
        System.out.println(function.apply("dada"));

        //方法引用的写法
        Function<String,String> function1= StaticExample::toUpperCase;
        System.out.println(function1.apply("dada"));

        /**
         * 有两个参数一个返回值
         */
        //lambda表达式的写法
        BiFunction<String,String,Integer> biFunction= (s1, s2)-> StaticExample.len(s1,s2);
        Integer apply = biFunction.apply("dada", "dada");
        System.out.println(apply);

        //方法引用的写法
        BiFunction<String,String,Integer> biFunction2= StaticExample::len;
        Integer apply2 = biFunction2.apply("dada", "dada");
        System.out.println(apply2);

    }
}
