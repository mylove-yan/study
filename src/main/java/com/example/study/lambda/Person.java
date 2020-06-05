/*******************************************************************************
 * @(#)Person.java 2020/6/5
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/5 15:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    // 性别枚举
    public enum Sex {
        MALE, FEMALE
    }
    private String name; // 姓名
    private Date birthday; // 生日
    private Sex gender; // 性别
    private String emailAddress; // 邮件地址
    private int age; // 年龄

    public void printPerson() {
        // 打印会员的个人信息
        System.out.println(this.name);
    }
}
