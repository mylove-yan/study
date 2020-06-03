/*******************************************************************************
 * @(#)ObjeactExample.java 2020/6/3
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.method;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 对象方法引用
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/3 9:04
 */
public class ObjectExample {

    /**
     * 抽象方法没有输入参数，不能使用对象方法引用
     * 比如说，如下函数式接口
     */
    public void not() {
        Runnable run = () -> {
        };
        Closeable c = () -> {
        };
        Supplier<String> s = () -> "";
    }

    public static void main(String[] args) {
        /**
         * 一个参数没有返回值 而且第一个参数必须是实例方法的类型
         */
        //lambda表达式的写法
        Consumer<Too> c1 = (Too too) -> too.foo();
        //方法引用
        Consumer<Too> c2 = Too::foo;


        //lambda表达式的写法
        Consumer<Too2> c3 = (Too2 too2) -> too2.foo();
        //方法引用
        Consumer<Too2> c4 = Too2::foo;

        c1.accept(new Too());
        c2.accept(new Too());
        c3.accept(new Too2());
        c4.accept(new Too2());


        /**
         * 两个参数无返回值
         */

        //lambda表达式的写法
        BiConsumer<Too2, String> c5 = (too2, str) -> too2.fo(str);
        //方法引用
        BiConsumer<Too2, String> c6 = Too2::fo;
        c5.accept(new Too2(), "dada");
        c6.accept(new Too2(), "dada");


        /**
         * 两个参数有返回值的写法
         */
        //lambda表达式的写法
        BiFunction<Prod, String, Integer> bf1 = (p, s) -> p.fun(s);
        //方法引用
        BiFunction<Prod, String, Integer> bf2 = Prod::fun;

        Integer dada = bf1.apply(new Prod(), "dada");
        System.out.println(dada);
        Integer dada2 = bf2.apply(new Prod(), "dada");
        System.out.println(dada2);


        /**
         * 自定义函数式接口演示对象方法引用
         */
        Execute ex1 = (p, name, size) -> p.run(name, size);
        Execute ex2 = Prod::run;
        ex1.run(new Prod(), "DADA", "19");
        ex2.run(new Prod(), "DADA", "19");
    }

}

interface Execute {
    public void run(Prod p, String name, String size);
}

class Prod {
    public void run(String name, String size) {
        System.out.println("run 开始执行" + "name:" + name + "size:" + size);
    }

    public Integer fun(String s) {
        return s.length();
    }

}

class Too {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("invoke");
    }
}

class Too2 {

    public void foo() {
        System.out.println("invoke");
    }

    public void fo(String str) {

    }
}
