package com.nxd.ftt.entity;

import java.util.Date;

/**
 * BaseEntity
 *
 * @author luhangqi
 * @date 2018/11/8
 */
public class BaseEntity {

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
     * 创建时间
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 修改时间
     *
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 创建人
     *
     * @return createor
     */
    public String getCreateor() {
        return createor;
    }

    /**
     * 修改人
     *
     * @return updateor
     */
    public String getUpdateor() {
        return updateor;
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

}
