package com.nxd.ftt.entity.system;
import com.google.gson.Gson;


/**
 * Permission
 *
 * @author luhangqi
 * @date 2018/11/04
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}