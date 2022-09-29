package com.zyx.prototype.shallow;

import java.util.Date;

public class Person implements Cloneable{
    private String name;
    private Date date;
    private Course course;

    public Person() {
    }

    public Person(String name, Date date, Course course) {
        this.name = name;
        this.date = date;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", course=" + course +
                '}';
    }

    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
