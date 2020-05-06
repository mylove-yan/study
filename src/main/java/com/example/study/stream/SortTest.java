package com.example.study.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {

    public static void main(String[] args) {
        withSortOperation();
    }

    public static void withNoOperation() {
        List<Student> list = getStudentList();
        for (Student s : list) {
            System.out.println("名字：" + s.getName() + ",年龄：" + s.getAge() + ",成绩：" + s.getGrade());
        }
    }

    public static void withSortOperation(){
        List<Student> list = getStudentList();
        list = list.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).collect(Collectors.toList());
        for (Student s : list) {
            System.out.println("名字：" + s.getName() + ",年龄：" + s.getAge() + ",成绩：" + s.getGrade());
        }
    }


    public static List<Student> getStudentList(){
        Student a = new Student("TEST1", 11, 19.36);
        Student b = new Student("TEST2", 12, 13.36);
        Student c = new Student("TEST3", 13, 17.36);
        Student d = new Student("TEST4", 14, 15.36);
        List<Student> list = new ArrayList<>();
        list.add(b);
        list.add(a);
        list.add(d);
        list.add(c);
        return list;
    }

}
