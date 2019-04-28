package com.example.dao;

import com.example.BaseTest;
import com.example.model.Message;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:22
 * description
 */
public class ProblemDaoTest extends BaseTest {
    @Autowired
    ProblemDao dao;
    @Test
    public void findAllProblem(){ System.out.println(dao.findAllProblem().toString()); }
    @Test
    public void findProblemByMid() { System.out.println(dao.findProblemByMid(1).toString()); }
    @Test
    public void findReplyByMid() { System.out.println(dao.findReplyByMid(1).toString()); }
    @Test
    public void deleteProblem() {
        System.out.println(dao.deleteProblem(1));
    }
    @Test
    public void addProblem() {
        Message problem=new Message();
        problem.setM_id(1);
        problem.setFrom_id(2);
        problem.setTo_id(1);
        problem.setCreate_time(new Date());
        problem.setM_title("dsadf");
        problem.setM_details("dfsa");
        problem.setM_type(3);
        problem.setM_state(2);
        System.out.println(dao.addProblem(problem));
    }
    @Test
    public void findProblemByUid(){ System.out.println(dao.findProblemByUid(7).toString()); }
    @Test
    public void addReply() {
        Message reply=new Message();
        reply.setM_id(7);
        reply.setFrom_id(4);
        reply.setTo_id(3);
        reply.setCreate_time(new Date());
        reply.setM_title("dsadf");
        reply.setM_details("dfsa");
        reply.setM_type(2);
        System.out.println(dao.addReply(reply));
    }
    @Test
    public void updateProblemState(){
        dao.updateProblemState(3);
        System.out.println(dao.findProblemByMid(3).toString());
    }
    //暂时不用
    @Test
    public void againProblem(){
        String details2="aaaaaa";
        String details=dao.findProblemByMid(6).getM_details();
        String details1=details+"/"+details2;
        dao.againProblem(details1,6);
    }
    @Test
    public void newProblemCount(){
        System.out.println(dao.newProblemCount());
    }
}
