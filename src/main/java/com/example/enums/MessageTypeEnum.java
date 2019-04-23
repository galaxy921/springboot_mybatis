package com.example.enums;

public enum MessageTypeEnum {
    NOTICE(0,"公告"), FILE(1,"申报"), REPLY(2, "回复"), PROBLEM(3, "问题"), REPORT(4,"中期报告");

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
