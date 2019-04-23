package com.example.enums;
//0 和 2 不用  CHECK(3, "审核中"),  PASS(4, "审核通过"),
public enum ProjectStateEnum {
    STOP(-2,"终止"), WAIT(-1, "待审核"), DISTRIBUTE(0, "未分配") ,RUNNING(1, "进行中"), SCORE(2, "已评分");

    private int state;

    private String stateInfo;

    private ProjectStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ProjectStateEnum stateOf(int index) {
        for (ProjectStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
