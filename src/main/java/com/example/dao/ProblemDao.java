package com.example.dao;

import com.example.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 第一个问题的p_id是0
 * 第一次回复的p_id是问题的id
 * 追加问题的p_id是回复的id
 * 第二次回复的p_id是追加问题的id
 *
 *
 * 刚提出的问题m_state=2
 * 回复的m_state=1
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
    Message findProblemByMid(int mid);

    /**
     * 根据问题id查看回复
     * @param mid
     * @return
     */
    Message findReplyByMid(int mid);

    /**
     * 删除问题
     * @return
     */
    int deleteProblem(int mid);

    //teachers
    /**
     * 回复问题
     * @param reply
     * @return
     */
    int addReply(Message reply);

    /**
     * 修改问题的状态
     * @param mid
     * @return
     */
    int updateProblemState(int mid);

    /**
     * 根据uid查找当前用户历史问题
     * @param uid
     * @return
     */
    List<Message> findProblemByUid(int uid);

    //students
    /**
     * 添加问题
     * @param problem
     * @return
     */
    int addProblem(Message problem);

    /**
     * 追加问题
     * @param details
     * @param mid
     * @return
     */
    int againProblem(String details,int mid);

}
