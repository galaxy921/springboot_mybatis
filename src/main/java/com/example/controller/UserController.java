package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:06
 * description
 */
//@RestController//返回json时候用
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/findalluser", method = RequestMethod.GET)
    public String findAllUser(Model model) {
        List<User> list = userService.findAllUser();
        model.addAttribute("userList", list);
        System.out.println(list.toString());
        return "root/user";
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {
        int uId = Integer.parseInt(request.getParameter("u_Id"));
        userService.deleteUser(uId);
        return "redirect:root/user";
    }
}
