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
    public boolean login(String u_no,String password,int position);

    public boolean logout();

    public int updateUserInfo(int uid);

    public List<User> findAllUser();

    public int deleteUser(int uid);

    public List<User> findUserByUid(int uid);

    public int updateUser(User user);

    public int insertUser(User user);

    public void userAnalyze(int uid);

    public void root();

}
