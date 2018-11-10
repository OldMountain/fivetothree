package com.nxd.ftt.service;

import com.nxd.ftt.entity.system.RolePermission;

import java.util.List;

/**
 * RolePermissionService
 *
 * @author luhangqi
 * @date 2018/11/08
 */
public interface RolePermissionService {


    /**
     * 查询列表
     *
     * @return
     */
    List<RolePermission> listAll();

    /**
     * 根据条件查询列表
     *
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
     * 根据id查询
     *
     * @param id
     * @return
     */
    RolePermission findById(Integer id);

    /**
     * 根据条件修改
     *
     * @param rolePermission
     * @return
     */
    int modify(RolePermission rolePermission);

    /**
     * 保存
     *
     * @param rolePermission
     * @return
     */
    int save(RolePermission rolePermission);

    ;

    /**
     * 保存角色权限
     *
     * @param permissions
     * @param roleId
     * @return
     */
    int save(Integer roleId, String[] permissions);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int remove(Integer id);

    /**
     * 根据id删除
     *
     * @param roleId
     * @return
     */
    public int removeByRoleId(Integer roleId);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int batchRemove(Integer[] ids);
}