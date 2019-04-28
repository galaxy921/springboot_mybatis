package com.example.controller;

import com.example.model.Message;
import com.example.service.NoticeService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    //root查看所有公告
    @RequestMapping(value = "/rootfindallnotice", method = RequestMethod.GET)
    public String rootFindAllMessage(Model model) {
        List<Message> list = noticeService.findAllNotice();
        model.addAttribute("noticeList", list);
        System.out.println(list.toString());
        return "/root/notice";
    }
    //manager查看所有公告
    @RequestMapping(value = "/managerfindallnotice", method = RequestMethod.GET)
    public String managerFindAllMessage(Model model) {
        List<Message> list = noticeService.findAllNotice();
        model.addAttribute("noticeList", list);
        System.out.println(list.toString());
        return "/managers/notice";
    }
    //teacher查看所有公告
    @RequestMapping(value = "/teacherfindallnotice", method = RequestMethod.GET)
    public String teacherFindAllMessage(Model model) {
        List<Message> list = noticeService.findAllNotice();
        model.addAttribute("noticeList", list);
        System.out.println(list.toString());
        return "/teachers/notice";
    }
    //student查看所有公告
    @RequestMapping(value = "/studentfindallnotice", method = RequestMethod.GET)
    public String studentFindAllMessage(Model model) {
        List<Message> list = noticeService.findAllNotice();
        model.addAttribute("noticeList", list);
        System.out.println(list.toString());
        return "/students/notice";
    }
    //查看公告详情m_id
    @RequestMapping(value = "/findnoticebymid",method = RequestMethod.GET)
    @ResponseBody
    public Message findProblemdByMid(int mid) throws JSONException {
        System.out.println("根据id查找公告信息"+mid);
        Message reply=noticeService.findNoticeByMid(mid);
        return reply;
    }
    //删除公告
    @RequestMapping(value = "/deletenotice", method = RequestMethod.GET)
    public String deleteMessage(int mid) {
        noticeService.deleteNotice(mid);
        return "redirect:/notice/findallnotice";
    }
    //发布公告
    @RequestMapping(value = "/addnotice")
    public String addNotice(){
        return "/root/notice_add";
    }
    //添加公告
    @RequestMapping(value = "/insertnotice",method = RequestMethod.GET)
    @Deprecated
    public String addProblem(Message notice,Model model){
        System.out.println(notice.toString());
        notice.setCreate_time(new Date());
        noticeService.addNotice(notice);
        System.out.println("添加问题"+notice.toString());
        return "redirect:/notice/findallnotice";
    }
}
