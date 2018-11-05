package com.nxd.ftt.entity.result;

import com.github.pagehelper.PageInfo;
import com.nxd.ftt.enumtype.ResultEnum;

import java.util.List;

/**
 * 分页响应参数
 *
 * @author luhangqi
 * @date 2018/11/5
 */
public class ResultPage<T> {

    private int code;
    private String msg;
    private int count;
    private List<T> data;

    public ResultPage() {
    }

    public ResultPage(int code, int count, List<T> data) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public ResultPage(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static ResultPage success(List list) {
        PageInfo pageInfo = new PageInfo(list);
        return new ResultPage(ResultEnum.SUCCESS.getCode(), (int) pageInfo.getTotal(), pageInfo.getList());
    }

    public static ResultPage fail(String msg) {
        return new ResultPage(ResultEnum.ERROR.getCode(), msg, 0, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
