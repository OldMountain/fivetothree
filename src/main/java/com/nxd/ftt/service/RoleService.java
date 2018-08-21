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

    Role getRoleById(Role role) throws SQLException;

    List<Role> listAll() throws SQLException;

    List<Role> list(Role role) throws SQLException;

    List<Role> getRoleListByParentId(Role role) throws SQLException;

    int modify(Role role) throws SQLException;

    int save(Role role) throws SQLException;

    int remove(Role role) throws SQLException;


}
