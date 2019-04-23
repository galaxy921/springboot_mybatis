package com.example.service.impl;

import com.example.dao.ProjectDao;
import com.example.model.Project;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:36
 * description
 */
@Service
public class ProjectServiceImpl implements ProjectService

{
    @Autowired
    ProjectDao projectDao;
    @Override
    public List<Project> findAllProject() {
        return projectDao.findAllProject();
    }

    @Override
    public List<Project> findProjectByPid(int pid) { return projectDao.findProjectByPid(pid); }

    @Override
    public void downloadReport(int pid) { }

    @Override
    public void downloadFile(int pid) { }

    @Override
    public int insertProject(Project project) { return projectDao.insertProject(project); }

    @Override
    public int updateProject(Project project) { return projectDao.updateProject(project); }

    @Override
    public int deleteProject(int pid){return projectDao.deleteProject(pid);}

    @Override
    public List<Project> findNewProject() { return projectDao.findNewProject(); }

    @Override
    public List<Project> findAssignProject() { return projectDao.findAssignProject(); }

    @Override
    public List<Project> findRunningProject() { return projectDao.findRunningProject(); }

    @Override
    public List<Project> findStopProject() { return projectDao.findStopProject(); }

    @Override
    public List<Project> findRunningProjectByTid(int tid) { return projectDao.findRunningProjectByTid(tid); }

    @Override
    public List<Project> findStopProjectByTid(int tid) { return projectDao.findStopProjectByTid(tid);
    }
}
