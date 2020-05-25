package com.example.demo.student.service;


import com.example.demo.student.dao.IStudentDao;

import com.example.demo.student.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author szl
 * @create 2020-16-24 18:16
 */
@Service
public class StudentSerivce {

    @Autowired
    private IStudentDao iStudentDao;

    public int save(Student student) {
        return iStudentDao.save(student);
    }

    public List<Student> getlist() {
        return iStudentDao.getlist();
    }

    public List<Student> getszl(String id) {
        return iStudentDao.getszl(id);
    }

    public int update(Student student) {
        return  iStudentDao.update(student);
    }

    public int delete(String id) {
        return iStudentDao.delete(id);
    }


}
