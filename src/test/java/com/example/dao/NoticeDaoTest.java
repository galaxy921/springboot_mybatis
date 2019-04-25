package com.example.dao;

import com.example.BaseTest;
import com.example.model.Message;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 11:22
 * description
 */
public class NoticeDaoTest extends BaseTest {
    @Autowired
    NoticeDao dao;
    @Test
    public void findAllNotice(){ System.out.println(dao.findAllNotice()); }
    @Test
    public void findNoticeByMid() { System.out.println(dao.findNoticeByMid(1).toString()); }
    @Test
    public void addNotice() {
        Message notice=new Message();
        notice.setM_id(6);
        notice.setFrom_id(0);
        notice.setTo_id(0);
        notice.setCreate_time(new Date());
        notice.setM_title("dsadf");
        notice.setM_details("dfsa");
        notice.setM_type(3);
        notice.setM_state(1);
        System.out.println(dao.addNotice(notice));
    }
    @Test
    public void deleteNotice() {
        System.out.println(dao.deleteNotice(6));
    }
}
