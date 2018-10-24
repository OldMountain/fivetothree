package com.nxd.ftt.entity;
import com.google.gson.Gson;
import java.util.Date;

/**
 * Dictionary
 *
 * @author luhangqi
 * @date 2018/10/24
 */
public class Dictionary {

    /**
     * 
     */
    private Integer id;

    /**
     * 字典数据值
     */
    private String value;

    /**
     * 字典数据显示文本
     */
    private String text;

    /**
     * 字典父ID
     */
    private String parent;

    /**
     * 状态：0:不可用，1:可用
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
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** 字典数据值
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /** 字典数据显示文本
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /** 字典父ID
     *
     * @return parent
     */
    public String getParent() {
        return parent;
    }

    /** 状态：0:不可用，1:可用
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
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 字典数据值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 字典数据显示文本
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 字典父ID
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * 状态：0:不可用，1:可用
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
}