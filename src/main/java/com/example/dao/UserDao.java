package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 10:51
 * description
 */
@Component
public interface UserDao {
    /**
     * 用户登录
     * @return
     */
    //根据用户名和密码查询用户
    //注解的两个参数会自动封装成map集合，括号内即为键
    void login(@Param("u_no")int u_no,@Param("password")String password);

    /**
     * 用户登出
     * @return
     */
    boolean logout();

    /**
     * 修改个人信息 暂时不用
     * @param uid
     * @return
     */
    int updateUserInfo(int uid);

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    //root
    /**
     * 查看所有用户信息
     * @return List
     */
    List<User> findAllUser();

    /**
     * 删除用户信息
     * @return
     */
    int deleteUser(int uid);

    /**
     * 根据id查找用户信息
     * @param uid
     * @return
     */
    User findUserByUid(int uid);

    /**
     * 根据no查找用户信息
     * @param uno
     * @return
     */
    User findUserByUno(int uno);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 用户行为分析 项目主题
     * @param
     */
    void userAnalyzeTitle();

    /**
     * 用户行为分析 问题类型
     * @param
     */
    void userAnalyzeType();

    /**
     * 用户行为分析 项目完成情况
     * @param
     */
    void userAnalyzeAchieve();

    /**
     * 权限设置
     */
    void root();

}
