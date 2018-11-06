package com.nxd.ftt.entity;

import com.nxd.ftt.controller.base.BaseEntity;

public class Role extends BaseEntity {
    /**
     * @mbg.generated 2017-12-04
     */
    private Integer roleId;

    /**
     * @mbg.generated 2017-12-04
     */
    private String roleName;

    /**
     * @mbg.generated 2017-12-04
     */
    private Integer parentId;

    private String desc;


    public Role() {
    }

    public Role(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return ROLE_ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return ROLE_NAME
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * @return PARENT_ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}