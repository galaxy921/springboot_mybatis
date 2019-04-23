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
public interface NoticeDao {

    /**
     * 列出公告列表
     * @return List
     */
    List<Message> findAllNotice();

    /**
     * 查看公告详情
     * @param uid
     * @return
     */
    List<Message> findNoticeByMid(int mid);

    /**
     * 添加消息信息
     * @param notice
     * @return
     */
    int addNotice(Message notice);

    /**
     * 删除消息信息
     * @return
     */
    int deleteNotice(int mid);

}
