package com.nxd.ftt.dao;

import com.nxd.ftt.entity.Tree;
import com.nxd.ftt.entity.system.Permission;

import java.util.List;

/**
 * PermissionDao
 *
 * @author luhangqi
 * @date 2018/11/05
 */
public interface PermissionDao {

    /**
     * 查询
     * @param permission
     * @return
     */
    List<Permission> list(Permission permission);

    /**
     * 查询
     * @param id
     * @return
     */
    Permission findById(String id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param permission
    * @return
    */
    int insert(Permission permission);

    /**
    * 更新
    * @param permission
    * @return
    */
    int update(Permission permission);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);

    /**
     * 树形权限
     *
     * @return
     */
    List<Tree> getPermissionTree();
}