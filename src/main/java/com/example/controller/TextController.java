package com.example.controller;

import com.example.model.Text;
import com.example.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@RequestMapping("/text")
public class TextController {
    @Autowired
    TextService textService;

    @RequestMapping(value = "/findTextById",method = RequestMethod.GET)
    public String findTextById(Model model){
        Map<String,Object> map = new HashMap<>();
        //成功返回true
        Text text = textService.findTextById(1);
        List<Text> textList = new ArrayList<Text>();
        for (int i = 0; i <10; i++) {
            textList.add(new Text(i,"123"));
        }
        map.put("users",textList);
        map.put("user",text);
        model.addAllAttributes(map);
        return "index";

    }


//    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
//    public String findAll(Model model){
//        Map<String,Object> map = new HashMap<>();
//        //成功返回true
//        User user = userService.findUserById(1);
//        List<User> userList = new ArrayList<User>();
//        for (int i = 0; i <10; i++) {
//            userList.add(new User(i,"123"));
//        }
//        map.put("users",userList);
//        map.put("user",user);
//        model.addAllAttributes(map);
//        return "index";
//
//    }
}
