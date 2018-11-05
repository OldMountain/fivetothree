package com.nxd.ftt.service;

import com.nxd.ftt.entity.system.Permission;

import java.util.List;

/**
 * PermissionService
 *
 * @author luhangqi
 * @date 2018/11/05
 */
public interface PermissionService {


    /**
     * 查询列表
     * @return
     */
    List<Permission> listAll();

    /**
     * 根据条件查询列表
     * @param permission
     * @return
     */
    List<Permission> list(Permission permission);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Permission findById(Integer id);

    /**
     * 根据条件修改
     * @param permission
     * @return
     */
    int modify(Permission permission);

    /**
     * 保存
     * @param permission
     * @return
     */
    int save(Permission permission);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int remove(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchRemove(Integer[] ids);
}