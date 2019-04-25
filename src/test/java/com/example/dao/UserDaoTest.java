package com.example.dao;

import com.example.BaseTest;
import com.example.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:22
 * description
 */
public class UserDaoTest extends BaseTest {
    @Autowired
    UserDao dao;
    @Test
    public void updateUser(){
        User user=new User();
        user.setU_id(1);
        user.setU_no(1515401);
        user.setU_name("dadsf");
        user.setPassword("123");
        user.setPosition(1);
        System.out.println(dao.updateUser(user));
    }
    @Test
    public void findAllUser(){ System.out.println(dao.findAllUser()); }
    @Test
    public void deleteUser() {
        System.out.println(dao.deleteUser(1));
    }
    @Test
    public void findUserByUid() {
        System.out.println(dao.findUserByUid(1));
    }
    @Test
    public void insertUser() {
        User user=new User();
        user.setU_id(1);
        user.setU_no(123);
        user.setPassword("123");
        user.setPosition(1);
        System.out.println(dao.insertUser(user));
    }

}
