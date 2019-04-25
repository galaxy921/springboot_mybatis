package com.example.model;

public class Project {
    //ID
    private Integer p_id;
    //项目
    private String p_name;
    //信息详情
    private String p_details;
    //附件文件
    private String p_file;
    //中期报告
    private String p_report;
    //评分
    private String score;
    //创建时间
    private String percentage;
    //项目状态
    private Integer p_state;

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_details() {
        return p_details;
    }

    public void setP_details(String p_details) {
        this.p_details = p_details;
    }

    public String getP_file() {
        return p_file;
    }

    public void setP_file(String p_file) {
        this.p_file = p_file;
    }

    public String getP_report() {
        return p_report;
    }

    public void setP_report(String p_report) {
        this.p_report = p_report;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public Integer getP_state() {
        return p_state;
    }

    public void setP_state(Integer p_state) {
        this.p_state = p_state;
    }

    @Override
    public String toString() {
        return "Project{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_details='" + p_details + '\'' +
                ", p_file='" + p_file + '\'' +
                ", p_report='" + p_report + '\'' +
                ", score='" + score + '\'' +
                ", percentage='" + percentage + '\'' +
                ", p_state=" + p_state +
                '}';
    }
}
