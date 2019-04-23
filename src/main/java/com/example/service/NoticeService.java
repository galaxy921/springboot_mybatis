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
public interface NoticeService {
    public List<Message> findAllNotice();

    public List<Message> findNoticeByMid(int mid);

    public int addNotice(Message notice);

    public int deleteNotice(int mid);
}
