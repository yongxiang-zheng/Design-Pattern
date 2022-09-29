package com.zyx.prototype.shallow;


import java.util.Date;

public class MyTest {
    public static void main(String[] args) {
        Date date = new Date();

        Course course = new Course("数学");
        Person person1 = new Person("小米",date,course);
        Person person3 = (Person) person1.clone();

        course.setName("英语");

        System.out.println(person1);
        System.out.println(person3);
    }
}
