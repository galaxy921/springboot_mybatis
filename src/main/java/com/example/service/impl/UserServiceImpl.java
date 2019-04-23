package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;
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
public class UserServiceImpl implements UserService

{
    @Autowired
    UserDao userDao;

    @Override
    public boolean login(String uno, String password, int position) { return userDao.login(uno,password,position); }

    @Override
    public boolean logout() { return userDao.logout(); }

    @Override
    public int updateUserInfo(int uid) { return userDao.updateUserInfo(uid); }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public int deleteUser(int uid){return userDao.deleteUser(uid);}

    @Override
    public List<User> findUserByUid(int uid) {return userDao.findUserByUid(uid);}

    @Override
    public int updateUser(User user) { return userDao.updateUser(user);}

    @Override
    public int insertUser(User user) { return userDao.insertUser(user); }

    @Override
    public void userAnalyze(int uid) { userDao.userAnalyze(uid); }

    @Override
    public void root() { userDao.root(); }
}
