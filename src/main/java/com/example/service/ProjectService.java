package com.example.service;

import com.example.model.Project;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:05
 * description
 */
public interface ProjectService {
    public List<Project> findAllProject();

    public List<Project> findProjectByPid(int pid);

    public void downloadReport(int pid);

    public void downloadFile(int pid);

    public int insertProject(Project project);

    public int updateProject(Project project);

    public int deleteProject(int pid);

    public List<Project> findNewProject();

    public List<Project> findAssignProject();

    public List<Project> findRunningProject();

    public List<Project> findStopProject();

    public List<Project> findRunningProjectByTid(int tid);

    public List<Project> findStopProjectByTid(int tid);




}
