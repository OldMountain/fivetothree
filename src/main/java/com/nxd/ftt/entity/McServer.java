package com.nxd.ftt.entity;
import com.google.gson.Gson;
import com.nxd.ftt.mchelper.entity.server.McServerInfo;

import java.util.Date;

/**
 * McServer
 *
 * @author luhangqi
 * @date 2018/10/24
 */
public class McServer {

    /**
     * ID
     */
    private Integer id;

    /**
     * 在线人数
     */
    private Integer online;

    /**
     * 最大人数
     */
    private Integer max;

    /**
     * 服务器地址
     */
    private String address;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 服务器名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 服务器备注信息
     */
    private String remark;

    /**
     * 公告
     */
    private String notice;

    /**
     * 状态0:关闭，1:正常开服，2:维护，3:即将开服
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createor;

    /**
     * 修改人
     */
    private String updateor;

    /**
     * 显示排序
     */
    private Integer showOrder;

    /**
     * 服务器实时数据
     */
    private McServerInfo serverData;


    /** ID
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** 在线人数
     *
     * @return online
     */
    public Integer getOnline() {
        return online;
    }

    /** 最大人数
     *
     * @return max
     */
    public Integer getMax() {
        return max;
    }

    /** 服务器地址
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /** 端口
     *
     * @return port
     */
    public Integer getPort() {
        return port;
    }

    /** 服务器名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /** 版本
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /** 服务器备注信息
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /** 公告
     *
     * @return notice
     */
    public String getNotice() {
        return notice;
    }

    /** 状态0:关闭，1:正常开服，2:维护，3:即将开服
     *
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /** 创建时间
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 修改时间
     *
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 创建人
     *
     * @return createor
     */
    public String getCreateor() {
        return createor;
    }

    /** 修改人
     *
     * @return updateor
     */
    public String getUpdateor() {
        return updateor;
    }


    /**
     * ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 在线人数
     */
    public void setOnline(Integer online) {
        this.online = online;
    }

    /**
     * 最大人数
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * 服务器地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 端口
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 服务器名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 服务器备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 公告
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * 状态0:关闭，1:正常开服，2:维护，3:即将开服
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人
     */
    public void setCreateor(String createor) {
        this.createor = createor;
    }

    /**
     * 修改人
     */
    public void setUpdateor(String updateor) {
        this.updateor = updateor;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public McServerInfo getServerData() {
        return serverData;
    }

    public void setServerData(McServerInfo serverData) {
        this.serverData = serverData;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }
}