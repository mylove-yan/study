/*******************************************************************************
 * @(#)Test.java 2020/6/5
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/5 15:49
 */
public class Test {
    public static void main(String[] args) {
        List<Person> roster = getPersonList();

    }
    public static List<Person> getPersonList(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三",new Date(), Person.Sex.FEMALE,"jl20103962@163.com",23));
        list.add(new Person("李四",new Date(), Person.Sex.MALE,"xp20103962@163.com",18));
        list.add(new Person("王3",new Date(), Person.Sex.FEMALE,"490419382@163.com",46));
        list.add(new Person("冯9",new Date(), Person.Sex.MALE,"kl5466333@163.com",27));
        list.add(new Person("朱7",new Date(), Person.Sex.FEMALE,"jl20103961@163.com",21));
        return list;
    }

    /**
     * 方法一：创建方法，寻找符合条件的会员，但方法所指定的条件是硬编码
     * 因为这个方法只能匹配一种条件，即年龄大于指定的数字，若是需要匹配其他的条件，
     * 比如性别是男的，一种最简单的方式就是，再次创建一个方法，让他匹配另一种条件，即性别。
     * 这个方法的适应性很窄，若是你的程序进行升级，这个方法很有可能就不能用了。
     * 假设你修改了会员实体类的数据结构，把年龄 age 的数据类型修改为字符 String 类型；
     * 假设你修改了计算年龄的算法，年龄小于某个指定的数字。
     * 这样的一些修改，这个方法不但不能实现业务，而且有可能编译错误。
     * 另外，就算后期不去升级程序，为了适应匹配其他的条件，
     * 比如指定性别，指定邮件地址等，我们需要创建许多类似的方法去满足业务的需要。
     * @param roster
     * @param age
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /**
     * 创建一个适应性更好的方法，去寻找符合条件的会员
     * 如下这个方法比起上一个例子的方法 printPersonsOlderThan ，它的适应性更好，目标会员的条件是他们的年龄范围。
     * 若是把会员的年龄作为筛选条件，这个方法 printPersonsWithinAgeRange 适应性比起上一个例子要好。
     * 但问题是，若是要把会员的性别作为筛选条件呢？或是要把会员的年龄范围和指定性别作为联合筛选条件呢？
     * 若是你决定改变会员实体类的数据结构，比如增加会员的关系状态，地理位置，接着要把他们作为筛选条件呢？
     * 很显然，我们需要创建很多方法满足各种条件的筛选，这些方法是分离的（ separate method ），独立的，因此代码是很易碎的（ brittle code ）。
     * 一种替换这些易碎代码的方案是，把筛选的条件定义在一个独立的类中。
     * @param roster
     * @param low
     * @param high
     */
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    /**
     * 在这个方法中，所有的应用会员放在 List 集合 roster 中，遍历每一个会员，判断他是否符合条件。
     * 方法的第二个 CheckPerson 接口类型的参数 tester，它就是筛选会员的条件。
     * 判断的方式是调用 tester.test 方法，若是该方法返回 true， 表明当前会员符合条件，调用当前会员的 printPerson 方法，打印会员的信息。
     * @param roster
     * @param tester
     */
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * 下面我们需要为这个接口 CheckPerson 定义实现类，实现抽象方法 test，
     * 实现的逻辑，即筛选条件，是符合美国义务兵役制度的会员，假设符合这一制度的具体条件是男性且年龄在 18 至 25 岁之间。
     * 为了能够完成这个场景，最后我们需要调用方法 printPersons。
     * 这个方法 printPersons 看起来不是那么易碎了，就算我们后期升级程序，
     * 需要修改了会员实体类 Person 的数据结构，或是修改筛选条件，我们依旧不需要改变这个方法printPersons ，
     * 因为这个方法不再出现判断条件，更没有出现会员实体类 Person 的任何字段。
     * 具体的判断条件被定义在一个独立的接口实现类中。
     * 但是，我们依旧面临一个问题，为了能够筛选出符合条件的应用会员，
     * 我们需要去维护一个接口 CheckPerson 和一个实现类 CheckPersonEligibleForSelectiveService ，
     * 这依旧是件麻烦事。于是我们想到了改进的方案，使用匿名类（ anonymous class ）代替独立定义的接口实现类。
     * 比如这个例子中，实现类 CheckPersonEligibleForSelectiveService 就是独立定义的，下一个例子我们要使用匿名类替换它。
     *
     * List<Person> roster = ...
     * printPersons(roster, new CheckPersonEligibleForSelectiveService());
     */
    class CheckPersonEligibleForSelectiveService implements CheckPerson {
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE &&
                    p.getAge() >= 18 && p.getAge() <= 25;
        }
    }



}
