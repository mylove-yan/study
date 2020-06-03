/*******************************************************************************
 * @(#)Example5.java 2020/6/3
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造方法引用
 * 如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用
 * 语法
 * 类名::new
 */
public class Example5 {

    public static void main(String[] args) {

        /**
         * 无参数有返回值
         */
        Supplier<Person> s1 = () -> new Person();
        Supplier<Person> s2 = Person::new;
        s1.get();
        s2.get();

        Supplier<List> s3 = ArrayList::new;
        Supplier<Thread> s4 = Thread::new;
        Supplier<Set> s5 = HashSet::new;
        Supplier<String> s6 = String::new;


        /**
         * 有参数无返回值
         */
        Consumer<Integer> c1 = (age) -> new Account(age);
        Consumer<Integer> c2 = Account::new;
        c2.accept(123);

        Function<String, Integer> fu = (str) -> Integer.valueOf(str);
        Function<String, Integer> fu1 = Integer::valueOf;

        /**
         * 有参数有返回值
         */
        Function<String, Account> fu2 = (str) -> new Account();
        Function<String, Account> fu3 = Account::new;
        fu3.apply("admin");
    }

}

class Account {
    public Account() {
        System.out.println("Account");
    }

    public Account(int age) {
        System.out.println("Account(age)");
    }

    public Account(String name) {
        System.out.println("Account(name)");
    }
}

class Person {
    public Person() {
        System.out.println("new Person()");
    }
}

