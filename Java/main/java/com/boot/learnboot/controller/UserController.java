package com.boot.learnboot.controller;

import com.boot.learnboot.entity.User;
import com.boot.learnboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String getUser(Model model){
        model.addAttribute("users", userService.findAll());
        return "/views/user";
    }

    @RequestMapping("/user/add")
    public String showNewUser(Model model){
        model.addAttribute("user", new User());
        return "/views/adduser";
    }

    @PostMapping("/user/save")
    public String saveUser(User user, RedirectAttributes ra){
        ra.addFlashAttribute("messenge","Thêm thành công!");
        System.out.println(user.toString());
        return "redirect:/user";
    }

}
