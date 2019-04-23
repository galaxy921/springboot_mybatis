package com.example.enums;

public enum UserTypeEnum {
    SUPER_MANAGER(0, "超级管理员"), SCHOOL_MANAGER(1, "校级管理员"), TEACHER(2, "指导老师"),STUDENT(3, "学生");

    private int state;

    private String stateInfo;

    private UserTypeEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static UserTypeEnum stateOf(int index) {
        for (UserTypeEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
