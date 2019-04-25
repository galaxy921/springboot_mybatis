package com.example.controller;

import com.example.model.Project;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    //查看项目列表
    @RequestMapping(value = "/findallproject/pid={}", method = RequestMethod.GET)
    public String findAllProject(Model model) {
        List<Project> list = projectService.findAllProject();
        model.addAttribute("projectList", list);
        System.out.println(list.toString());
        return "/root/r_projectList";
    }
    //根据id查找项目信息
    @RequestMapping(value="/findprojectbypid",method=RequestMethod.GET)
    public String findProjectByPid(Model model,@RequestParam(name = "p_id") int pid){
//        int pid = (Integer.parseInt(request.getParameter("p_id")));
        System.out.println(pid);
        Project project=projectService.findProjectByPid(pid);
        model.addAttribute("project",project);
        System.out.println(project.toString());
        return "/root/r_project";
    }
    //删除项目信息
    @RequestMapping(value = "/deleteproject", method = RequestMethod.GET)
    public String deleteProject(HttpServletRequest request) {
        int pid = Integer.parseInt(request.getParameter("p_id"));
        projectService.deleteProject(pid);
        return "redirect:root/user";
    }


}
