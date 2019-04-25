package com.example.enums;

public enum MessageTypeEnum {
    NOTICE(0,"公告"), PROBLEM(1,"问题"), REPLY(2, "回复"), FILE(3, "申报"), REPORT(4,"中期报告");

    private int state;

    private String stateInfo;

    private MessageTypeEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    /**
     * 依据传入的state返回相应的enum值
     */
    public static MessageTypeEnum stateOf(int index) {
        for (MessageTypeEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}
