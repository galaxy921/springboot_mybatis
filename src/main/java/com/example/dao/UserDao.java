package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
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
    boolean login(String u_no,String password,int position);

    /**
     * 用户等出
     * @return
     */
    boolean logout();

    /**
     * 修改个人信息
     * @param uid
     * @return
     */
    int updateUserInfo(int uid);

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
    List<User> findUserByUid(int uid);

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 用户行为分析
     * @param uid
     */
    void userAnalyze(int uid);

    /**
     * 权限设置
     */
    void root();

}
