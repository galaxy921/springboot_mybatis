package com.example.controller;

import com.example.enums.ProjectStateEnum;
import com.example.model.Project;
import com.example.model.User;
import com.example.service.ProjectService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    UserService userService;
    //root查看项目列表
    @RequestMapping(value = "/rootfindallproject", method = RequestMethod.GET)
    public String rootFindAllProject(Model model) {
        List<Project> list = projectService.findAllProject();
        model.addAttribute("projectList", list);
        System.out.println(list.toString());
        return "/root/r_projectList";
    }
    //manager查看项目列表
    @RequestMapping(value = "/managerfindallproject", method = RequestMethod.GET)
    public String managerFindAllProject(Model model) {
        List<Project> list1 = projectService.findAllProject();
        List<Project> list2 = projectService.findNewProject();
        List<Project> list3 = projectService.findAssignProject();
        List<Project> list4 = projectService.findRunningProject();
        List<Project> list5 = projectService.findStopProject();
        model.addAttribute("projectList1", list1);
        model.addAttribute("projectList2", list2);
        model.addAttribute("projectList3", list3);
        model.addAttribute("projectList4", list4);
        model.addAttribute("projectList5", list5);
        System.out.println("1"+list1.toString());
        System.out.println("2"+list2.toString());
        System.out.println("3"+list3.toString());
        System.out.println("4"+list4.toString());
        System.out.println("5"+list5.toString());
        return "/managers/m_projectList";
    }
    //teacher查看项目列表
    @RequestMapping(value = "/teacherfindallproject", method = RequestMethod.GET)
    public String teacherFindAllProject(Model model) {
        List<Project> list = projectService.findAllProject();
        model.addAttribute("projectList", list);
        System.out.println(list.toString());
        return "/teachers/t_projectList";
    }
    //student查看项目列表
    @RequestMapping(value = "/studentfindallproject", method = RequestMethod.GET)
    public String studentFindAllProject(Model model) {
        List<Project> list = projectService.findAllProject();
        model.addAttribute("projectList", list);
        System.out.println(list.toString());
        return "/students/s_projectList";
    }
    //root根据id查找项目信息
    @RequestMapping(value="/rootfindprojectbypid/{pid}",method=RequestMethod.GET)
    public String rootFindProjectByPid(Model model,@PathVariable("pid") int pid){
        System.out.println("根据id查找项目信息"+pid);
        Project project=projectService.findProjectByPid(pid);
        //查找学生信息
        int uid=project.getU_id();
        System.out.println("根据projet中的uid查找指导教师信息"+uid);
        User student=userService.findUserByUid(uid);
        //查找指导老师信息
        int tid=project.getT_id();
        System.out.println("根据projet中的tid查找指导教师信息"+tid);
        User teacher=new User();
       if(tid!=0){
        teacher=userService.findUserByUid(tid);}
        System.out.println(teacher);
        //查找申报文件信息
        String upload="已上传";
        String not_upload="未上传";
        if(project.getP_file().equals("null")||project.getP_file().equals("")){ model.addAttribute("file",not_upload); }
        else { model.addAttribute("file",upload); }
        //查找中期报告文件信息
        if(project.getP_report().equals("null")||project.getP_report().equals("")){ model.addAttribute("report",not_upload); }
        else{ model.addAttribute("report",upload); }
        //查找项目状态
        String stateinfo=ProjectStateEnum.stateOf(project.getP_state()).getStateInfo();
        //查找项目完成情况
        String percentage=project.getPercentage()+"%";
        System.out.println(percentage);
        model.addAttribute("percentage",percentage);
        model.addAttribute("teacher",teacher);
        model.addAttribute("project",project);
        model.addAttribute("stateinfo",stateinfo);
        System.out.println(project.toString());
        return "/root/r_project";
    }
    //manager根据id查找项目信息
    @RequestMapping(value="/managerfindprojectbypid/{pid}",method=RequestMethod.GET)
    public String managerFindProjectByPid(Model model,@PathVariable("pid") int pid){
        System.out.println("根据id查找项目信息"+pid);
        Project project=projectService.findProjectByPid(pid);
        //查找学生信息
        int uid=project.getU_id();
        System.out.println("根据projet中的uid查找指导教师信息"+uid);
        User student=userService.findUserByUid(uid);
        //查找指导老师信息
        int tid=project.getT_id();
        System.out.println("根据projet中的tid查找指导教师信息"+tid);
        User teacher=new User();
        if(tid!=0){
            teacher=userService.findUserByUid(tid);}
        System.out.println(teacher);
        //查找申报文件信息
        String upload="已上传";
        String not_upload="未上传";
        if(project.getP_file().equals("null")||project.getP_file().equals("")){ model.addAttribute("file",not_upload); }
        else { model.addAttribute("file",upload); }
        //查找中期报告文件信息
        if(project.getP_report().equals("null")||project.getP_report().equals("")){ model.addAttribute("report",not_upload); }
        else{ model.addAttribute("report",upload); }
        //查找项目状态
        String stateinfo=ProjectStateEnum.stateOf(project.getP_state()).getStateInfo();
        //查找项目完成情况
        String percentage=project.getPercentage()+"%";
        System.out.println(percentage);
        model.addAttribute("percentage",percentage);
        model.addAttribute("teacher",teacher);
        model.addAttribute("project",project);
        model.addAttribute("stateinfo",stateinfo);
        System.out.println(project.toString());
        return "/managers/m_project";
    }
    //teacher根据id查找项目信息
    @RequestMapping(value="/teacherfindprojectbypid/{pid}",method=RequestMethod.GET)
    public String teacherFindProjectByPid(Model model,@PathVariable("pid") int pid){
        System.out.println("根据id查找项目信息"+pid);
        Project project=projectService.findProjectByPid(pid);
        //查找学生信息
        int uid=project.getU_id();
        System.out.println("根据projet中的uid查找指导教师信息"+uid);
        User student=userService.findUserByUid(uid);
        //查找指导老师信息
        int tid=project.getT_id();
        System.out.println("根据projet中的tid查找指导教师信息"+tid);
        User teacher=new User();
        if(tid!=0){
            teacher=userService.findUserByUid(tid);}
        System.out.println(teacher);
        //查找申报文件信息
        String upload="已上传";
        String not_upload="未上传";
        if(project.getP_file().equals("null")||project.getP_file().equals("")){ model.addAttribute("file",not_upload); }
        else { model.addAttribute("file",upload); }
        //查找中期报告文件信息
        if(project.getP_report().equals("null")||project.getP_report().equals("")){ model.addAttribute("report",not_upload); }
        else{ model.addAttribute("report",upload); }
        //查找项目状态
        String stateinfo=ProjectStateEnum.stateOf(project.getP_state()).getStateInfo();
        //查找项目完成情况
        String percentage=project.getPercentage()+"%";
        System.out.println(percentage);
        model.addAttribute("percentage",percentage);
        model.addAttribute("teacher",teacher);
        model.addAttribute("project",project);
        model.addAttribute("stateinfo",stateinfo);
        System.out.println(project.toString());
        return "/teachers/t_project";
    }
    //student根据id查找项目信息
    @RequestMapping(value="/studentfindprojectbypid/{pid}",method=RequestMethod.GET)
    public String studentFindProjectByPid(Model model,@PathVariable("pid") int pid){
        System.out.println("根据id查找项目信息"+pid);
        Project project=projectService.findProjectByPid(pid);
        //查找学生信息
        int uid=project.getU_id();
        System.out.println("根据projet中的uid查找指导教师信息"+uid);
        User student=userService.findUserByUid(uid);
        //查找指导老师信息
        int tid=project.getT_id();
        System.out.println("根据projet中的tid查找指导教师信息"+tid);
        User teacher=new User();
        if(tid!=0){
            teacher=userService.findUserByUid(tid);}
        System.out.println(teacher);
        //查找申报文件信息
        String upload="已上传";
        String not_upload="未上传";
        if(project.getP_file().equals("null")||project.getP_file().equals("")){ model.addAttribute("file",not_upload); }
        else { model.addAttribute("file",upload); }
        //查找中期报告文件信息
        if(project.getP_report().equals("null")||project.getP_report().equals("")){ model.addAttribute("report",not_upload); }
        else{ model.addAttribute("report",upload); }
        //查找项目状态
        String stateinfo=ProjectStateEnum.stateOf(project.getP_state()).getStateInfo();
        //查找项目完成情况
        String percentage=project.getPercentage()+"%";
        System.out.println(percentage);
        model.addAttribute("percentage",percentage);
        model.addAttribute("teacher",teacher);
        model.addAttribute("project",project);
        model.addAttribute("stateinfo",stateinfo);
        System.out.println(project.toString());
        return "/students/s_project";
    }
    //删除项目信息
    @RequestMapping(value = "/deleteproject", method = RequestMethod.GET)
    public String deleteProject(HttpServletRequest request) {
        int pid = Integer.parseInt(request.getParameter("p_id"));
        projectService.deleteProject(pid);
        return "redirect:root/user";
    }


}
