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
    //首页
    @RequestMapping("/index")
    public String index(Model model){
        System.out.println("用户登录首页：");
        return "/login";
    }
    //登录
    @RequestMapping("/login")
    public String login(int u_no,String password,Model model){
        System.out.println("用户登录："+u_no+password);
//        userService.login(u_no,password);
        User user=userService.findUserByUno(u_no);
        System.out.println("这密码到底是啥呀"+user.getPassword());
        int position=user.getPosition();
        model.addAttribute("user",user);
        if(password.equals(user.getPassword())&&position==0){return "/root/r_index";}
        else if(password.equals(user.getPassword())&&position==1){return "managers/m_index";}
        else if(password.equals(user.getPassword())&&position==2){return "teachers/t_index";}
        else if(password.equals(user.getPassword())&&position==3){return "students/s_index";}
        return "/404";
    }
    //修改个人信息
    @RequestMapping("/updateuserinfo")
    public String updateUserInfo(User user,Model model){
        userService.updateUser(user);
        System.out.println("修改信息成功");
        User u=userService.findUserByUid(user.getU_id());
        System.out.println(u.toString());
        model.addAttribute("user",u);
        return "/root/user_info";
    }
    //查看所有用户
    @RequestMapping(value = "/findalluser", method = RequestMethod.GET)
    public String findAllUser(Model model) {
        List<User> list = userService.findAllUser();
        model.addAttribute("userList", list);
        System.out.println(list.toString());
        return "/root/user";
    }
    //删除用户
    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {
        int uId = Integer.parseInt(request.getParameter("u_Id"));
        userService.deleteUser(uId);
        return "redirect:/root/user";
    }
    //修改用户信息
    @RequestMapping("/updateuser")
    public String updateUser(User user,Model model){
        userService.updateUser(user);
        System.out.println("修改信息成功");
        User u=userService.findUserByUid(user.getU_id());
        System.out.println(u.toString());
        model.addAttribute("user",u);
        return "我不太懂这是个啥 jQuery？？？";
    }
    //根据id查找用户信息
    //根据no查找用户信息
    //添加用户信息
    //用户行为分析
}
