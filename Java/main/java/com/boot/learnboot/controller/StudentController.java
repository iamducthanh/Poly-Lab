package com.boot.learnboot.controller;

import com.boot.learnboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    HttpServletRequest req;

    @GetMapping("create")
    public String showCreateStudent(Model model){
        model.addAttribute("student", new Student());
        return "views/addstudent";
    }

    @PostMapping("create")
    public String createStudent(Student student){
        req.setAttribute("name", student.getName());
        req.setAttribute("age", student.getAge());
        return "views/editstudent";
    }

}
