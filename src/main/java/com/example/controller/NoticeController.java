package com.example.controller;

import com.example.model.Message;
import com.example.service.NoticeService;
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
 * @author :
 * create : 2019-04-21 11:06
 * description
 */
//@RestController//返回json时候用
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "/findallnotice", method = RequestMethod.GET)
    public String findAllMessage(Model model) {
        List<Message> list = noticeService.findAllNotice();
        model.addAttribute("noticeList", list);
        System.out.println(list.toString());
        return "root/user";
    }

    @RequestMapping(value = "/deletenotice", method = RequestMethod.GET)
    public String deleteMessage(HttpServletRequest request) {
        int mid = Integer.parseInt(request.getParameter("m_id"));
        noticeService.deleteNotice(mid);
        return "redirect:root/user";
    }
}
