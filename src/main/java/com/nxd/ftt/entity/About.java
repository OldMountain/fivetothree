package com.nxd.ftt.entity;
import com.google.gson.Gson;
import java.util.Date;

/**
 * About
 *
 * @author luhangqi
 * @date 2018/10/24
 */
public class About {

    /**
     * ID
     */
    private Integer id;

    /**
     * 版本信息
     */
    private String version;

    /**
     * 使用的框架
     */
    private String frame;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 说明
     */
    private String remark;

    /**
     * 下载地址
     */
    private String url;

    /**
     * 参与者
     */
    private String takePartIn;

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


    /** ID
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** 版本信息
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /** 使用的框架
     *
     * @return frame
     */
    public String getFrame() {
        return frame;
    }

    /** 项目名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /** 说明
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /** 下载地址
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /** 参与者
     *
     * @return takePartIn
     */
    public String getTakePartIn() {
        return takePartIn;
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
     * 版本信息
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 使用的框架
     */
    public void setFrame(String frame) {
        this.frame = frame;
    }

    /**
     * 项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 下载地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 参与者
     */
    public void setTakePartIn(String takePartIn) {
        this.takePartIn = takePartIn;
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
}