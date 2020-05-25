package com.example.demo.student.controller;


import com.example.demo.student.pojo.Student;
import com.example.demo.student.service.StudentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author szl
 * @create 2020-29-21 15:29
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentSerivce studentSerivce;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Student> getList(){

        List<Student> list= studentSerivce.getlist();

        return  list;
    }
//    创建学生
@RequestMapping(value = "/",method = RequestMethod.POST)
public int create(@RequestBody Student student){
    return studentSerivce.save(student);
}
//    学生详情
//   获取详情信息
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public List<Student> getxinxi(@PathVariable("id") String id){
        return studentSerivce.getszl(id);
    }
    //        更改学生信息
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public int update(@RequestBody Student student){
        return studentSerivce.update(student);
    }
    //    删除学生信息
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public int delete(@PathVariable("id") String id) {
        return studentSerivce.delete(id);
    }

}
