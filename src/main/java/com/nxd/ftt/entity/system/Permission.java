package com.nxd.ftt.entity.system;
import com.google.gson.Gson;
import java.util.Date;

/**
 * Permission
 *
 * @author luhangqi
 * @date 2018/11/05
 */
public class Permission {

    /**
     * 
     */
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限
     */
    private String permission;

    /**
     * 权限对应的菜单ID
     */
    private Integer menuId;

    /**
     * 权限对应的菜单名称
     */
    private String menuName;

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

    /** 权限名称
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /** 权限
     *
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /** 权限对应的菜单ID
     *
     * @return menuId
     */
    public Integer getMenuId() {
        return menuId;
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
     * 权限名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 权限对应的菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}