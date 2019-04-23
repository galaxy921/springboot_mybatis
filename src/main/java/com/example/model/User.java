package com.example.model;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 10:51
 * description
 */
public class User {
    //ID
    private Integer u_id;
    //No
    private Integer u_no;
    //名称
    private String u_name;
    //密码
    private String password;
    //职位
    private Integer position;
    //邮箱
    private String email;
    //电话
    private String phone;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getU_no() {
        return u_no;
    }

    public void setU_no(Integer u_no) {
        this.u_no = u_no;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_no=" + u_no +
                ", u_name='" + u_name + '\'' +
                ", password='" + password + '\'' +
                ", position=" + position +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

