/*******************************************************************************
 * @(#)Base.java 2020/6/2
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.method;

/**
 * 父类Base(用于演示super与this在方法引用中的使用)
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/2 19:31
 */
public class Base {
    public String toUpper(String str) {
        System.out.println("base to upper");
        return str.toUpperCase();
    }
}
