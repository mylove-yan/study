package com.example.study.stream;

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
}
