/*******************************************************************************
 * @(#)SetTest.java 2020/10/20
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.stream;

import java.util.HashSet;
import java.util.Set;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/10/20 11:20
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Student> s = new HashSet<>();
        s.add(new Student("TEST1", 16, 19.36));
        s.add(new Student("TEST1", 16, 19.36));
        s.add(new Student("TEST1", 16, 19.36));
        s.forEach((a)->{
            System.out.println(a.getName()+a.getAge());
        });
    }
}
