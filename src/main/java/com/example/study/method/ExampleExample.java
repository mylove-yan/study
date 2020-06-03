/*******************************************************************************
 * @(#)ExampleExample.java 2020/6/2
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.method;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * /**
 * 实例方法引用
 * 如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
 * 语法 inst::instMethod
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/2 19:32
 */
public class ExampleExample extends Base {
    /**
     * 无参数有返回值
     *
     * @return
     */
    public String put() {
        return "hello";
    }

    /**
     * 有参数无返回值
     *
     * @param size
     */
    public void con(Integer size) {
        System.out.println("size : " + size);
    }

    /**
     * 有参数有返回值
     *
     * @param str
     * @return
     */
    public String toUpper(String str) {
        System.out.println("current to upper");
        return str.toUpperCase();
    }

    /**
     * 演示this 与 supper  使用方法引用
     */
    public void test() {
        Function<String, String> f4 = this::toUpper;
        System.out.println(f4.apply("this"));

        Function<String, String> f5 = super::toUpper;
        System.out.println(f5.apply("super"));
    }

    public static void main(String[] args) {

        /**
         * 无参数，有返回值
         */
        //lambda表达式的写法
        Supplier<String> stringSupplier = () -> new ExampleExample().put();
        System.out.println(stringSupplier.get());

        //方法引用
        Supplier<String> stringSupplier1 = new ExampleExample()::put;
        System.out.println(stringSupplier1.get());

        /**
         * 有参数，无返回值
         */
        //lambda表达式的写法
        Consumer<Integer> consumer = (x) -> new ExampleExample().con(x);
        consumer.accept(100);

        //方法引用
        Consumer<Integer> consumer1 = new ExampleExample()::con;
        consumer1.accept(100);

        /**
         * 有参数有返回值
         */

        //lambda表达式的写法
        Function<String, String> function = (x) -> new ExampleExample().toUpper(x);
        System.out.println(function.apply("dada"));
        //方法引用
        Function<String, String> function1 = new ExampleExample()::toUpper;
        System.out.println(function1.apply("dada"));

    }

}
