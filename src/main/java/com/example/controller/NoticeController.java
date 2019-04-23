package com.example.controller;

import com.example.model.Message;
import com.example.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-04-21 11:06
 * description
 */
//@RestController//返回json时候用
@Controller
@RequestMapping("/message")
public class NoticeController {
    @Autowired
    ProblemService problemService;

    @RequestMapping(value = "/findallmessage", method = RequestMethod.GET)
    public String findAllMessage(Model model) {
        List<Message> list = problemService.findAllMessage();
        model.addAttribute("messageList", list);
        System.out.println(list.toString());
        return "root/user";
    }

    @RequestMapping(value = "/deletemessage", method = RequestMethod.GET)
    public String deleteMessage(HttpServletRequest request) {
        int mId = Integer.parseInt(request.getParameter("m_Id"));
        problemService.deleteMessage(mId);
        return "redirect:root/user";
    }
}
