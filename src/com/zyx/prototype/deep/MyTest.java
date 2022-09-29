package com.zyx.prototype.deep;

import com.zyx.prototype.deep.Person;

import java.util.Date;

public class MyTest {
    public static void main(String[] args) {
        Date date = new Date();
        Course course = new Course("数学");
        Person person1 = new Person("小米",date,course);
        Person person3 = (Person) person1.clone();

        course.setName("英语");

        // 深拷贝 引用也进行拷贝，改变person1的引用对象不影响person3的属性
        System.out.println(person1);
        System.out.println(person3);
    }
}
