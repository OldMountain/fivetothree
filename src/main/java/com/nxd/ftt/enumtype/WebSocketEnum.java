package com.nxd.ftt.enumtype;

/**
 * WebSocketEnum
 *
 * @author luhangqi
 * @date 2017/11/15
 */
public enum WebSocketEnum {
    WS_CMD_ORDER_NOTIFY("orderNotify","订单通知"),
    WS_CMD_HEARTBEAT("heartbeat","心跳"),
    WS_CLIENT_ROOMSTATUSNOTIFY("roomStatusNotify","房态改变通知"),
    WS_REFRESH("refresh","刷新页面"),
    WS_OUTROOM_NOTIFY("outRoomNotify","退房推送")
    ;
    private String cmd;
    private String desc;

    WebSocketEnum(String cmd, String desc) {
        this.cmd = cmd;
        this.desc = desc;
    }

    public String getCmd() {
        return cmd;
    }

    public String getDesc() {
        return desc;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
