package com.example.controller;

import com.example.model.Project;
import com.example.service.ProjectService;
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
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/findallproject", method = RequestMethod.GET)
    public String findAllProject(Model model) {
        List<Project> list = projectService.findAllProject();
        model.addAttribute("projectList", list);
        System.out.println(list.toString());
        return "root/user";
    }

    @RequestMapping(value = "/deleteproject", method = RequestMethod.GET)
    public String deleteProject(HttpServletRequest request) {
        int pId = Integer.parseInt(request.getParameter("p_Id"));
        projectService.deleteProject(pId);
        return "redirect:root/user";
    }
}
