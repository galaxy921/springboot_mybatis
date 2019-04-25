package com.example.enums;

public enum MessageStateEnum {
    PUBLIC(0, "公开"), PRIVATE(1, "私人"), NOT_RESOLVED(2, "未解决"), FINISH(3, "已解决");

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
