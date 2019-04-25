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

    public Message findProblemByMid(int mid);

    public Message findReplyByMid(int mid);

    public int deleteProblem(int mid);

    public int addProblem(Message problem);

    public List<Message> findProblemByUid(int uid);

    public int addReply(Message reply);
}
