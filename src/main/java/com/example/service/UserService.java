package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:05
 * description
 */
public interface UserService {
    public void login(int uno,String password);

    public boolean logout();

    public int updateUserInfo(int uid);

    public List<User> findAllUser();

    public int deleteUser(int uid);

    public User findUserByUid(int uid);

    public User findUserByUno(int uno);

    public int updateUser(User user);

    public int insertUser(User user);

    public void userAnalyzeTitle();

    public void userAnalyzeType();

    public void userAnalyzeAchieve();

    public void root();

}
