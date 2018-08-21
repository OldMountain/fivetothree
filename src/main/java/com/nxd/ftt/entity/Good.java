package com.nxd.ftt.entity;
import com.google.gson.Gson;


/**
 * Good
 *
 * @author luhangqi
 * @date 2018/05/30
 */
public class Good {

    /**
     * 
     */
    private Integer id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 现价
     */
    private String price;

    /**
     * 原价
     */
    private String originalPrice;

    /**
     * 商品描述
     */
    private String detail;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String modifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 单位
     */
    private String unit;


    /** 
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** 商品标题
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /** 现价
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /** 原价
     *
     * @return originalPrice
     */
    public String getOriginalPrice() {
        return originalPrice;
    }

    /** 商品描述
     *
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /** 创建时间
     *
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /** 修改时间
     *
     * @return modifyTime
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /** 备注
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /** 创建人
     *
     * @return createUser
     */
    public String getCreateUser() {
        return createUser;
    }

    /** 修改人
     *
     * @return modifyUser
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /** 单位
     *
     * @return unit
     */
    public String getUnit() {
        return unit;
    }


    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商品标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 现价
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 原价
     */
    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 商品描述
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 修改人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}