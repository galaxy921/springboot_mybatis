package com.example.service.impl;

import com.example.dao.NoticeDao;
import com.example.model.Message;
import com.example.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NoticeServiceImpl implements NoticeService

{
    @Autowired
    NoticeDao noticeDao;

    @Override
    public List<Message> findAllNotice() {
        return noticeDao.findAllNotice();
    }

    @Override
    public Message findNoticeByMid(int mid) {
        return noticeDao.findNoticeByMid(mid);
    }

    @Override
    public int addNotice(Message notice) {
        return noticeDao.addNotice(notice);
    }

    @Override
    public int deleteNotice(int mid) {
        return noticeDao.deleteNotice(mid);
    }
}
