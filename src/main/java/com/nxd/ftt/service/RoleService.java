package com.nxd.ftt.service;

import com.nxd.ftt.entity.Role;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * RoleService
 *
 * @author OldMountain
 * @date 2017/12/4
 */
@Repository
public interface RoleService {

    Role getRoleById(Role role);

    List<Role> listAll();

    List<Role> list(Role role);

    List<Role> getRoleListByParentId(Role role);

    int modify(Role role);

    int save(Role role);

    int remove(Role role);

    /**
     * 根据userId查询角色
     * @param userId
     * @return java.util.List<com.nxd.ftt.entity.Role>
     */
    List<Role> findRoleByUser(String userId);

}
