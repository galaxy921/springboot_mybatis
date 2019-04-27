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
    ProblemDao messageDao;

    @Override
    public List<Message> findAllProblem() {
        return messageDao.findAllProblem();
    }

    @Override
    public Message findProblemByMid(int mid) {
        return messageDao.findProblemByMid(mid);
    }

    @Override
    public Message findReplyByMid(int mid) {
        return messageDao.findReplyByMid(mid);
    }

    @Override
    public int deleteProblem(int mid) {
        return messageDao.deleteProblem(mid);
    }

    @Override
    public int addProblem(Message problem) {
        return messageDao.addProblem(problem);
    }

    @Override
    public List<Message> findProblemByUid(int uid) {
        return messageDao.findProblemByUid(uid);
    }

    @Override
    public int addReply(Message reply) {
        return messageDao.addReply(reply);
    }

    @Override
    public void updateProblemState(int mid) { messageDao.updateProblemState(mid);}
}
