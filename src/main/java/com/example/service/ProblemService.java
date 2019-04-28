package com.example.service;

import com.example.model.Message;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:05
 * description
 */
public interface ProblemService {
    public List<Message> findAllProblem();

    public List<Message> findNewProblem();

    public int newProblemCount();

    public Message findProblemByMid(int mid);

    public Message findReplyByMid(int mid);

    public int deleteProblem(int mid);

    public int addProblem(Message problem);

//    public List<Message> findProblemByUid(int uid);
    public Message findProblemByUid(int uid);

    public List<Message> findReplyByUid(int uid);

    public int addReply(Message reply);

    public void updateProblemState(int mid);
}
