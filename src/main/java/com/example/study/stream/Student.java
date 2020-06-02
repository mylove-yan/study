package com.example.study.stream;

import java.math.BigDecimal;

public class Student {
    /**
    *姓名
    */
    private String name;
    /**
    *年龄
    */
    private Integer age;
    /**
    *成绩
    */
    private Double grade;

    public Student(String name, Integer age, Double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public static int compareAge(Student o1, Student o2) {

        if((o1.getAge() == null || o1.getAge().equals("--")) && (o2.getAge() == null || o2.getAge().equals("--"))){
            return 0;
        }

        if(o1.getAge() == null || o1.getAge().equals("--")){
            return 1;
        }

        if(o2.getAge() == null || o2.getAge().equals("--")){
            return -1;
        }

        return -new BigDecimal(o1.getAge()).compareTo(new BigDecimal(o2.getAge()));
    }
}
