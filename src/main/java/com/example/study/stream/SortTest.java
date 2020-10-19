package com.example.study.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class SortTest {

    public static void main(String[] args) {
        withLambdaComparator();
    }

    public static void withNoOperation() {
        List<Student> list = getStudentList();
        for (Student s : list) {
            System.out.println("名字：" + s.getName() + ",年龄：" + s.getAge() + ",成绩：" + s.getGrade());
        }
    }

    /**
     * 空值进行排序时，如果不做处理会报错,
     */
    public static void withSortOperation(){
        List<Student> list = getStudentList();
        list = list.stream().sorted(Comparator.comparing(Student::getGrade,Comparator.nullsFirst(Double::compareTo)).reversed()).collect(Collectors.toList());
        for (Student s : list) {
            System.out.println("名字：" + s.getName() + ",年龄：" + s.getAge() + ",成绩：" + s.getGrade());
        }
    }

    /**
     * 使用Collections.sort 进行排序
     */
    public static void withComparator(){
        List<Student> list = getStudentList();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
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
        });
        list.forEach((value)->{
            System.out.println("名字：" + value.getName() + ",年龄：" + value.getAge() + ",成绩：" + value.getGrade());
        });
    }

    /**
     * 使用Collections.sort 进行排序
     */
    public static void withLambdaComparator(){
        List<Student> list = getStudentList();
        Collections.sort(list, (o1, o2) -> {
            if((o1.getGrade() == null || o1.getGrade().equals("--")) && (o2.getGrade() == null || o2.getGrade().equals("--"))){
                return 0;
            }
            /**
             *   空值排在前面排在后面空值方法
             */
            if(o1.getGrade() == null || o1.getGrade().equals("--")){
                return 1;
            }

            if(o2.getGrade() == null || o2.getGrade().equals("--")){
                return -1;
            }

            return -new BigDecimal(o1.getGrade()).compareTo(new BigDecimal(o2.getGrade()));
        });
        list.forEach((value)->{
            System.out.println("名字：" + value.getName() + ",年龄：" + value.getAge() + ",成绩：" + value.getGrade());
        });
    }

    /**
     *静态方法引用实现
     */
    public static void withStaticComparator(){
        List<Student> list = getStudentList();
        Collections.sort(list,Student::compareAge);
        list.forEach((value)->{
            System.out.println("名字：" + value.getName() + ",年龄：" + value.getAge() + ",成绩：" + value.getGrade());
        });
    }

    /**
     * 使用jdk 新增的list 默认排序
     */
    public static void withListSort(){
        List<Student> another = getStudentList();
        another.sort(Student::compareAge);
        ArrayList<Student> list = getStudentList();
        list.sort(Student::compareAge);
        list.forEach((value)->{
            System.out.println("名字：" + value.getName() + ",年龄：" + value.getAge() + ",成绩：" + value.getGrade());
        });
    }


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
