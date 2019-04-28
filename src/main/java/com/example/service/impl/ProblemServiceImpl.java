package com.example.service.impl;

import com.example.dao.ProblemDao;
import com.example.model.Message;
import com.example.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
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
public class ProblemServiceImpl implements ProblemService

{
    @Autowired
    ProblemDao problemDao;

    @Override
    public List<Message> findAllProblem() {
        return problemDao.findAllProblem();
    }

    @Override
    public List<Message> findNewProblem() {
        return problemDao.findNewProblem();
    }

    @Override
    public int newProblemCount() {
        return problemDao.newProblemCount();
    }

    @Override
    public Message findProblemByMid(int mid) {
        return problemDao.findProblemByMid(mid);
    }

    @Override
    public Message findReplyByMid(int mid) {
        return problemDao.findReplyByMid(mid);
    }

    @Override
    public int deleteProblem(int mid) {
        return problemDao.deleteProblem(mid);
    }

    @Override
    public int addProblem(Message problem) {
        return problemDao.addProblem(problem);
    }

    @Override
    public List<Message> findReplyByUid(int uid) {
        return problemDao.findReplyByUid(uid);
    }

//    @Override
//    public List<Message> findProblemByUid(int uid) {
//        return problemDao.findProblemByUid(uid);
//    }

    @Override
    public Message findProblemByUid(int uid) { return problemDao.findProblemByUid(uid); }

    @Override
    public int addReply(Message reply) {
        return problemDao.addReply(reply);
    }

    @Override
    public void updateProblemState(int mid) { problemDao.updateProblemState(mid);}
}
