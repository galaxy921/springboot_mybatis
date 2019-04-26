package com.example.controller;

import com.example.model.Message;
import com.example.service.ProblemService;
import com.example.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    ProblemService problemService;
    @Autowired
    UserService userService;
    //查找所有问题
    @RequestMapping(value = "/findallproblem", method = RequestMethod.GET)
    public String findAllProblem(Model model) {
        List<Message> list = problemService.findAllProblem();
        model.addAttribute("problemList", list);
        System.out.println(list.toString());
        return "/root/r_problemList";
    }
    //查看问题详情m_id
    @RequestMapping(value = "/findproblembymid",method = RequestMethod.GET)
    @ResponseBody
        public Message findProblemdByMid( int mid) throws JSONException {
        System.out.println("问题啦啦啦啦啦啦");
        System.out.println("根据id查找问题信息"+mid);
        Message problem=problemService.findProblemByMid(mid);
//        String from_name=userService.findUserByUid(problem.getFrom_id()).getU_name();
//        System.out.println(problem.toString());
//        model.addAttribute("from_name",from_name);
//        model.addAttribute("create_time",problem.getCreate_time());
//        model.addAttribute("problem_details",problem.getM_details());
//        model.addAttribute("problem_state",problem.getM_state());
//        model.addAttribute();
//        JSONObject json = new JSONObject();
//        json.put("problem",problem);//ary就是你需要的值，ary可以是任何数据，包括数组、集合、等等。
//        HttpServletResponse response=null;
//        writeJson(response,json.toString());
//        System.out.println("我也不知道这是要干嘛呀"+response);
        return problem;
    }

    //根据问题查看回复 pid=mid
    @RequestMapping(value = "/findreplybymid",method = RequestMethod.GET)
    @ResponseBody
    public Message findReplyByMid(int mid) throws JSONException {
        System.out.println("回复啦啦啦啦啦啦");
        int pid=mid;
        System.out.println("根据id查找回复信息"+pid);
        Message reply=problemService.findReplyByMid(pid);
        System.out.println(reply.toString());
        return reply;
    }
    //添加问题
    //根据uid查找当前用户问题
    //回复问题
        //修改问题状态

    //删除问题  应该有级联删除    ****
    @RequestMapping(value = "/deleteproblem", method = RequestMethod.GET)
    public String deleteProblem(HttpServletRequest request,int mid) {
        System.out.println("删除呀呀呀呀呀");
        problemService.deleteProblem(mid);
        return "redirect:/root/r_problemList";
    }
    //将Json对象通过response回写
    public static void writeJson(HttpServletResponse response, String json) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(json);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
