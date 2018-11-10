package com.nxd.ftt.entity.system;
import com.google.gson.Gson;
import com.nxd.ftt.entity.BaseEntity;

import java.util.Date;

/**
 * RolePermission
 *
 * @author luhangqi
 * @date 2018/11/08
 */
public class RolePermission extends BaseEntity {

    /**
     * 
     */
    private Integer id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 权限
     */
    private String permission;


    /** 
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** 角色ID
     *
     * @return roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /** 权限
     *
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}