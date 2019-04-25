package com.example.dao;

import com.example.BaseTest;
import com.example.model.Project;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:22
 * description
 */
public class ProjectDaoTest extends BaseTest {
    @Autowired
    ProjectDao dao;
    @Test
    public void findAllProject(){ System.out.println(dao.findAllProject()); }
    @Test
    public void findProjectByPid() { System.out.println(dao.findProjectByPid(1).toString()); }

    @Test
    public void insertProject() {
        Project project=new Project();
        project.setP_id(2);
        project.setP_name("ssdf");
        project.setP_details("slasdhfkjsa");
        project.setP_file("/dsf/sdaf/sdaf");
        project.setP_report("dsadf");
        project.setScore("dfsa");
        project.setPercentage("fsadf");
        project.setP_state(0);
        System.out.println(dao.insertProject(project));
    }
    @Test
    public void updateProject(){
        Project project=new Project();
        project.setP_id(1);
        project.setP_name("123");
        project.setP_details("123");
        project.setP_file("123");
        project.setP_report("123");
        project.setScore("123");
        project.setPercentage("123");
        project.setP_state(1);
        System.out.println(dao.updateProject(project));
    }
    @Test
    public void deleteProject() {
        System.out.println(dao.deleteProject(1));
    }
    @Test
    public void findNewProject(){ System.out.println(dao.findNewProject()); }
    @Test
    public void findAssignProject(){ System.out.println(dao.findAssignProject()); }
    @Test
    public void findRunningProject(){ System.out.println(dao.findRunningProject()); }
    @Test
    public void findStopProject(){ System.out.println(dao.findStopProject()); }
    @Test
    public void findRunningProjectByTid(){ System.out.println(dao.findRunningProjectByTid(4)); }
    @Test
    public void findStopProjectByTid(){ System.out.println(dao.findStopProjectByTid(5)); }

}
