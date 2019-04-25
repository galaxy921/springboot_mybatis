package com.example.dao;

import com.example.model.Project;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 新建的项目p_state=-1
 *         percentage=0
 *         score=null
 *
 * @author :
 * create : 2019-04-21 10:51
 * description
 */
@Component
public interface ProjectDao {

    //root
    /**
     * 查看所有项目
     * @return List
     */
    List<Project> findAllProject();
    /**
     * 根据id查找项目信息
     * @param pid
     * @return
     */
    Project findProjectByPid(int pid);

    /**
     * 项目中期报告下载
     * @param pid
     */
    void downloadReport(int pid);

    /**
     * 下载审核文件
     * @param pid
     */
    void downloadFile(int pid);

    /**
     * 添加项目信息
     * @param project
     * @return
     */
    int insertProject(Project project);

    /**
     * 更新项目信息
     * @param project
     * @return
     */
    int updateProject(Project project);

    /**
     * 删除项目信息
     * @return
     */
    int deleteProject(int pid);

    //managers
    /**
     * 查看待审核的项目
     * @return List
     */
    List<Project> findNewProject();

    /**
     * 查看未分配的项目
     * @return List
     */
    List<Project> findAssignProject();

    /**
     * 查看进行中的项目
     * @return List
     */
    List<Project> findRunningProject();

    /**
     * 查看已终止的项目
     * @return List
     */
    List<Project> findStopProject();

    //teachers
    /**
     * 查看进行中的项目
     * @return List
     */
    List<Project> findRunningProjectByTid(int tid);

    /**
     * 查看已终止的项目
     * @return List
     */
    List<Project> findStopProjectByTid(int tid);


}
