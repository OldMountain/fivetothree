package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.RoleDao;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * RoleServiceImpl
 *
 * @author OldMountain
 * @date 2017/12/4
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleById(Role role) {
        Role role1 = new Role();
        role1.setRoleId(role.getRoleId());
        List<Role> list = roleDao.select(role1);
        if(list != null && list.size() == 1){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Role> listAll() {
        return roleDao.select(new Role());
    }

    @Override
    public List<Role> list(Role role) {
        return roleDao.select(role);
    }

    @Override
    public List<Role> getRoleListByParentId(Role role) {
        return roleDao.select(new Role(role.getParentId()));
    }

    @Override
    public int modify(Role role) {
        return roleDao.update(role);
    }

    @Override
    public int save(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public int remove(Role role) {
        return roleDao.delete(role.getRoleId());
    }


}
