package com.example.enums;

/**
 * 我发现  好像这个不需要 T T
 */
public enum MessageStateEnum {
    PUBLIC(0, "公告"), PRIVATE(1, "私人信息"), FINISH(2, "已解决"), NOT_RESOLVED(3, "未解决");

        private int state;

        private String stateInfo;

        private MessageStateEnum(int state, String stateInfo) {
            this.state = state;
            this.stateInfo = stateInfo;
        }

        public int getState() {
            return state;
        }

        public String getStateInfo() {
            return stateInfo;
        }

        public static MessageStateEnum stateOf(int index) {
            for (MessageStateEnum state : values()) {
                if (state.getState() == index) {
                    return state;
                }
            }
            return null;
        }


}
