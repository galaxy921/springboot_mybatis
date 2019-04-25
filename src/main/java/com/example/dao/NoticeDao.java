package com.example.dao;

import com.example.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *公告的from_id=to_id=0
 *公告的p_id=o
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
     * @param mid
     * @return
     */
    List<Message> findNoticeByMid(int mid);

    /**
     * 添加公告信息
     * @param notice
     * @return
     */
    int addNotice(Message notice);

    /**
     * 删除公告信息
     * @return
     */
    int deleteNotice(int mid);

}
