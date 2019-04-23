package com.example.dao;

import com.example.model.Message;
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
public interface ProblemDao {

    //root
    /**
     * 列出问题列表
     * @return List
     */
    List<Message> findAllProblem();

    /**
     * 查看问题详情
     * @param mid
     * @return
     */
    List<Message> findProblemByMid(int mid);

    /**
     * 根据问题id查看回复
     * @param mid
     * @return
     */
    List<Message> findReplyByMid(int mid);

    /**
     * 删除问题
     * @return
     */
    int deleteProblem(int mid);

    //teachers
    /**
     * 添加问题
     * @param problem
     * @return
     */
    int addProblem(Message problem);

    /**
     * 根据uid查找当前用户历史问题
     * @param uid
     * @return
     */
    List<Message> findProblemByUid(int uid);

    //students
    /**
     * 回复问题
     * @param reply
     * @return
     */
    int addReply(Message reply);

}
