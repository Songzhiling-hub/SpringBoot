package com.example.demo.student.pojo;

import org.springframework.stereotype.Component;

/**
 * @author szl
 * @create 2020-30-21 15:30
 */

public class Student {
    int id;
    String name;
    String sex;
    int age;
    int isdelete;

    public Student(int id, String name, String sex, int age, int isdelete) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isdelete = isdelete;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "Studnet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", isdelete=" + isdelete +
                '}';
    }
}
