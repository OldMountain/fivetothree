package com.nxd.ftt.dao;

import com.nxd.ftt.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    /**
     * 查询
     * @param role
     * @return int
     */
    List<Role> select(Role role);

    /**
     * 批量删除
     * @param roleId
     * @return int
     */
    int batchDelete(String[] roleId);

    /**
     * 根据roleId插入
     * @param role
     * @return int
     */
    int insert(Role role);

    /**
     * 根据roleId更新
     * @param role
     * @return int
     */
    int update(Role role);

    /**
     * 根据roleId删除
     * @param roleId
     * @return int
     */
    int delete(String roleId);

    /**
     * 根据userId查询角色
     * @param userId
     * @return java.util.List<com.nxd.ftt.entity.Role>
     */
    List<Role> findRoleByUser(String userId);
}