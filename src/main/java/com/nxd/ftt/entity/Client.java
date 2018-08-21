package com.nxd.ftt.entity;
import com.google.gson.Gson;


/**
 * Client
 *
 * @author luhangqi
 * @date 2018/05/29
 */
public class Client {

    /**
     * 
     */
    private Integer id;

    /**
     * 客户端名称
     */
    private String name;

    /**
     * 客户端大小
     */
    private double size;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 版本号
     */
    private String version;

    /**
     * 下载链接
     */
    private String link;

    /**
     * 备用下载链接1
     */
    private String link1;

    /**
     * 备用下载链接2
     */
    private String link2;

    /**
     * 备用下载链接2
     */
    private String link3;


    /** 
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** 客户端名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /** 客户端大小
     *
     * @return size
     */
    public double getSize() {
        return size;
    }

    /** 更新时间
     *
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /** 版本号
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /** 下载链接
     *
     * @return link
     */
    public String getLink() {
        return link;
    }

    /** 备用下载链接1
     *
     * @return link1
     */
    public String getLink1() {
        return link1;
    }

    /** 备用下载链接2
     *
     * @return link2
     */
    public String getLink2() {
        return link2;
    }

    /** 备用下载链接2
     *
     * @return link3
     */
    public String getLink3() {
        return link3;
    }


    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 客户端名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 客户端大小
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 下载链接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 备用下载链接1
     */
    public void setLink1(String link1) {
        this.link1 = link1;
    }

    /**
     * 备用下载链接2
     */
    public void setLink2(String link2) {
        this.link2 = link2;
    }

    /**
     * 备用下载链接2
     */
    public void setLink3(String link3) {
        this.link3 = link3;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}