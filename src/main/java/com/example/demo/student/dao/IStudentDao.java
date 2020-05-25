package com.example.demo.student.dao;


import com.example.demo.student.pojo.Student;

import java.util.List;

/**
 * @author szl
 * @create 2020-19-24 18:19
 */
public interface IStudentDao {




    int save(Student student);

    int update(Student student);

    int delete(String id);

    List<Student> getszl(String id);

    List<Student> getlist();
}
