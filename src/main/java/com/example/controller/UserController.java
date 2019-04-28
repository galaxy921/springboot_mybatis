package com.example.controller;

import com.example.enums.UserTypeEnum;
import com.example.model.Message;
import com.example.model.User;
import com.example.service.UserService;
import com.example.service.ProblemService;
import org.apache.ibatis.annotations.Param;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    ProblemService problemService;
    //首页
    @RequestMapping("/index")
    public String index(Model model){
        System.out.println("用户登录首页：");
        return "/login";
    }
    //登录
    @RequestMapping("/login")
    public String login(int u_no,String password,Model model,HttpServletRequest request){
        System.out.println("用户登录："+u_no+password);
        User user=userService.findUserByUno(u_no);
        System.out.println("这密码到底是啥呀"+user.getPassword());
        int position=user.getPosition();
        int count=problemService.newProblemCount();
        model.addAttribute("count",count);
        model.addAttribute("user",user);
        request.getSession().setAttribute("userid",user.getU_id());
        request.getSession().setAttribute("userno",user.getU_no());
        request.getSession().setAttribute("username",user.getU_name());
        request.getSession().setAttribute("password",user.getPassword());
        request.getSession().setAttribute("position",user.getPosition());
        request.getSession().setAttribute("email",user.getEmail());
        request.getSession().setAttribute("phone",user.getPhone());
        if(password.equals(user.getPassword())&&position==0){return "/root/r_index";}
        else if(password.equals(user.getPassword())&&position==1){return "managers/m_index";}
        else if(password.equals(user.getPassword())&&position==2){return "teachers/t_index";}
        else if(password.equals(user.getPassword())&&position==3){return "students/s_index";}
        return "/404";
    }
    //登出
    @RequestMapping("/logout")
    public String logout(){
        return "/user/index";
    }
    //修改个人信息 root
    @RequestMapping(value = "/updateuserinfo/{uid}",method = RequestMethod.POST)
    public String updateUserInfo(User user,Model model,@PathVariable("uid") int uid){
        System.out.println(user.toString());
        user.setU_id(uid);
        userService.updateUser(user);
        System.out.println("修改信息成功");
        User u=userService.findUserByUid(user.getU_id());
        System.out.println(u.toString());
        model.addAttribute("user",u);
        return "redirect:/user/findalluser";
    }
    //重置密码
    @RequestMapping(value = "/updatepassword/{uid}",method = RequestMethod.GET)
    public String updatePassword(User user, Model model, @PathVariable("uid") int uid, @Param("old_password")String old_password, @Param("password")String password, @Param("confrim")String confrim){
        System.out.println(user.toString());
        String oldpassword=userService.findUserByUid(uid).getPassword();
        System.out.println(old_password+"////"+oldpassword+"////"+confrim);
        if(oldpassword.equals(old_password)&&password.equals(confrim)){
            user.setU_id(uid);
            userService.updateUser(user);
            System.out.println("重置密码成功");
            User u=userService.findUserByUid(user.getU_id());
            System.out.println(u.toString());
            model.addAttribute("user",u);
            return "redirect:/user/findalluser";
        }
        else
            return "redirect:/user/updatepassword/"+user.getU_id();

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
    public String deleteUser(HttpServletRequest request,int uid) {
        System.out.println("删除呀呀呀呀呀");
        userService.deleteUser(uid);
        return "/user/findalluser";
    }
    //root根据id查找用户信息
    @RequestMapping(value = "/rootfinduserbyuid/{uid}",method = RequestMethod.GET)
    public String rootFindRootByUid(Model model, @PathVariable("uid") int uid){
        System.out.println("根据id查找用户信息"+uid);
        User user=userService.findUserByUid(uid);
        model.addAttribute("user",user);
        return "/root/user_info";
    }
    //manager根据id查找用户信息
    @RequestMapping(value = "/managerfinduserbyuid/{uid}",method = RequestMethod.GET)
    public String managerFindUserByUid(Model model, @PathVariable("uid") int uid){
        System.out.println("根据id查找用户信息"+uid);
        User user=userService.findUserByUid(uid);
        model.addAttribute("user",user);
        return "/managers/user_info";
    }
    //teacher根据id查找用户信息
    @RequestMapping(value = "/teacherfinduserbyuid/{uid}",method = RequestMethod.GET)
    public String teacherFindUserByUid(Model model, @PathVariable("uid") int uid){
        System.out.println("根据id查找用户信息"+uid);
        User user=userService.findUserByUid(uid);
        model.addAttribute("user",user);
        return "/teachers/user_info";
    }
    //student根据id查找用户信息
    @RequestMapping(value = "/studentfinduserbyuid/{uid}",method = RequestMethod.GET)
    public String studentFindUserByUid(Model model, @PathVariable("uid") int uid){
        System.out.println("根据id查找用户信息"+uid);
        User user=userService.findUserByUid(uid);
        model.addAttribute("user",user);
        return "/students/user_info";
    }
    //根据no查找用户信息
    //添加用户
    @RequestMapping(value = "/adduser")
    public String addUser(){
        return "/root/user_add";
    }
    //添加用户信息
    @RequestMapping(value = "/insertuser",method = RequestMethod.GET)
    public String insertUser(User user,Model model){
        System.out.println(user.toString());
        userService.insertUser(user);
        System.out.println("添加用户"+user.getU_no());
        return "redirect:/user/findalluser";
    }
    //用户行为分析
    //查看用户详情m_id
    @RequestMapping(value = "/finduser",method = RequestMethod.GET)
    @ResponseBody
    public User findUserByMid(int uid) throws JSONException {
        System.out.println("根据id查找用户信息"+uid);
        User user=userService.findUserByUid(uid);
        System.out.println(user.toString());
        return user;
    }
    //修改用户信息
    @RequestMapping("/updateuser")
    public String updateUser(User user,Model model){
        int uid=user.getU_id();
        userService.updateUser(user);
        System.out.println("修改信息成功");
        User u=userService.findUserByUid(user.getU_id());
        System.out.println(u.toString());
        model.addAttribute("user",u);
        return "redirect:/user/findalluser";
    }
}
