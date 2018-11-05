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
    private String rights;

    /**
     * @mbg.generated 2017-12-04
     */
    private Integer parentId;

    /**
     * @mbg.generated 2017-12-04
     */
    private String addQx;

    /**
     * @mbg.generated 2017-12-04
     */
    private String delQx;

    /**
     * @mbg.generated 2017-12-04
     */
    private String editQx;

    /**
     * @mbg.generated 2017-12-04
     */
    private String chaQx;

    /**
     * @mbg.generated 2017-12-04
     */
    private String qxId;

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
     * @return RIGHTS
     */
    public String getRights() {
        return rights;
    }

    /**
     * @param rights
     */
    public void setRights(String rights) {
        this.rights = rights == null ? null : rights.trim();
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

    /**
     * @return ADD_QX
     */
    public String getAddQx() {
        return addQx;
    }

    /**
     * @param addQx
     */
    public void setAddQx(String addQx) {
        this.addQx = addQx == null ? null : addQx.trim();
    }

    /**
     * @return DEL_QX
     */
    public String getDelQx() {
        return delQx;
    }

    /**
     * @param delQx
     */
    public void setDelQx(String delQx) {
        this.delQx = delQx == null ? null : delQx.trim();
    }

    /**
     * @return EDIT_QX
     */
    public String getEditQx() {
        return editQx;
    }

    /**
     * @param editQx
     */
    public void setEditQx(String editQx) {
        this.editQx = editQx == null ? null : editQx.trim();
    }

    /**
     * @return CHA_QX
     */
    public String getChaQx() {
        return chaQx;
    }

    /**
     * @param chaQx
     */
    public void setChaQx(String chaQx) {
        this.chaQx = chaQx == null ? null : chaQx.trim();
    }

    /**
     * @return QX_ID
     */
    public String getQxId() {
        return qxId;
    }

    /**
     * @param qxId
     */
    public void setQxId(String qxId) {
        this.qxId = qxId == null ? null : qxId.trim();
    }
}