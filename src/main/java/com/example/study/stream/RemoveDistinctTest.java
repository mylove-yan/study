/*******************************************************************************
 * @(#)RemoveDistinctTest.java 2020/10/19
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.stream;

import java.util.ArrayList;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/10/19 17:46
 */
public class RemoveDistinctTest {
    public static ArrayList<Student> getStudentList(){
        Student a = new Student("TEST1", 16, 19.36);
        Student b = new Student("TEST2", 19, 13.36);
        Student c = new Student("TEST3", 13, 17.36);
        Student d = new Student("TEST4", 21, 15.36);
        Student e = new Student("TEST5", 19, null);
        Student f = new Student("TEST6", 9, null);
        ArrayList<Student> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        return list;
    }
}
