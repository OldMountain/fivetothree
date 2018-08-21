package com.nxd.ftt.entity;

import com.google.gson.Gson;

/**
 * WebSocketModel
 *
 * @author luhangqi
 * @date 2017/11/15
 */
public class WebSocket {

    private String cmd;
    private Object data;

    public String getCmd() {
        return cmd;
    }

    public Object getData() {
        return data;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
