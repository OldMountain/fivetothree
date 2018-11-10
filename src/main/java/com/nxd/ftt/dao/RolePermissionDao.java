package com.nxd.ftt.dao;

import com.nxd.ftt.entity.system.RolePermission;

import java.util.List;

/**
 * RolePermissionDao
 *
 * @author luhangqi
 * @date 2018/11/08
 */
public interface RolePermissionDao {

    /**
     * 查询
     * @param rolePermission
     * @return
     */
    List<RolePermission> list(RolePermission rolePermission);

    /**
     * 根据角色ID查询权限ID
     *
     * @param roleId
     * @return
     */
    List<String> queryIdByRole(Integer roleId);

    /**
     * 查询
     * @param id
     * @return
     */
    RolePermission findById(Integer id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param rolePermission
    * @return
    */
    int insert(RolePermission rolePermission);

    /**
    * 更新
    * @param rolePermission
    * @return
    */
    int update(RolePermission rolePermission);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);

    /**
     * 根据roleId删除
     *
     * @param roleId
     * @return
     */
    int deleteByRoleId(Integer roleId);
}