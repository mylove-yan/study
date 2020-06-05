/*******************************************************************************
 * @(#)TestFunction.java 2020/6/5
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.function;

import java.util.function.Function;

/**
 * JDK自带Function函数式接口Function
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/5 8:04
 */
public class TestFunction {
    public static void main(String[] args) {
        Function<Integer,Integer> incr1 = x->x+1;
        Function<Integer,Integer> multiply = x-> x*2;
        int x = 2;
        System.out.println("f(x)=x+1,when x="+x+",f(x)="+incr1.apply(x));
        System.out.println("f(x)=x+1,g(x)=2x,when x="+x+",f(g(x))="+incr1.compose(multiply).apply(x));
        System.out.println("f(x)=x+1,g(x)=2x,when x="+x+",g(f(x))="+incr1.andThen(multiply).apply(x));
    }
}
