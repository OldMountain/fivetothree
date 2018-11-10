package com.nxd.ftt.entity;

import com.nxd.ftt.enumtype.ResultEnum;
import com.nxd.ftt.util.Const;

/**
 * Result
 *
 * @author OldMountain
 * @date 2017/12/5
 */
public class Result {

    private int code;

    private String message;

    private String status;

    private Object data;

    public Result() {
        this.setResult(ResultEnum.SUCCESS);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(ResultEnum resultEnum) {
        this.setCode(resultEnum.getCode());
        this.setMessage(resultEnum.getDesc());
        if (resultEnum.getCode() == 200) {
            this.setStatus(Const.SUCCESS);
        } else {
            this.setStatus(Const.FAIL);
        }
    }
}
