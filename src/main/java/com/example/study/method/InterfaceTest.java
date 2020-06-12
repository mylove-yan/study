/*******************************************************************************
 * @(#)InterfaceTest.java 2020/6/12
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.method;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口小实验
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/12 8:39
 */
public class InterfaceTest {

    interface Person{
        String say(String name);
        void doSomething();
        default void doAnother(){
            System.out.println("没啥好说的");
        };
    }
    static class LiMing implements Person{

        @Override
        public String say(String name) {
            return "My name is : "+name;
        }

        @Override
        public void doSomething() {
            System.out.println("大家好");
        }
    }

    public static void main(String[] args) {
        LiMing l = new LiMing();
        l.doAnother();
        List<String> list = new ArrayList<>();
    }
}
