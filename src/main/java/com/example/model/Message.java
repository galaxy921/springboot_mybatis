package com.example.model;

import java.util.Date;

public class Message {
    //ID
    private Integer m_id;
    //发送人
    private Integer from_id;
    //接收人
    private Integer to_id;
    //创建时间
    private Date create_time;
    //信息简介
    private String m_title;
    //信息详情
    private String m_details;
    //信息类型
    private Integer m_type;
    //信息状态
    private Integer m_state;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }

    public Integer getTo_id() {
        return to_id;
    }

    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public String getM_details() {
        return m_details;
    }

    public void setM_details(String m_details) {
        this.m_details = m_details;
    }

    public Integer getM_type() {
        return m_type;
    }

    public void setM_type(Integer m_type) {
        this.m_type = m_type;
    }

    public Integer getM_state() {
        return m_state;
    }

    public void setM_state(Integer m_state) {
        this.m_state = m_state;
    }

    @Override
    public String toString() {
        return "Message{" +
                "m_id=" + m_id +
                ", from_id=" + from_id +
                ", to_id=" + to_id +
                ", create_time=" + create_time +
                ", m_title='" + m_title + '\'' +
                ", m_details='" + m_details + '\'' +
                ", m_type=" + m_type +
                ", m_state=" + m_state +
                '}';
    }
}
