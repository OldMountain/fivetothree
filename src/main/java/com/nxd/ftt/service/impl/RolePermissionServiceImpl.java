package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.RolePermissionDao;
import com.nxd.ftt.entity.system.RolePermission;
import com.nxd.ftt.service.RolePermissionService;
import com.nxd.ftt.util.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RolePermissionServiceImpl
 *
 * @author luhangqi
 * @date 2018/11/08
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public List<RolePermission> listAll() {
        return rolePermissionDao.list(new RolePermission());
    }

    /**
     * 根据条件查询列表
     *
     * @param rolePermission
     * @return
     */
    @Override
    public List<RolePermission> list(RolePermission rolePermission) {
        return rolePermissionDao.list(rolePermission);
    }

    /**
     * 根据角色ID查询权限ID
     *
     * @param roleId
     * @return
     */
    @Override
    public List<String> queryIdByRole(Integer roleId) {

        return rolePermissionDao.queryIdByRole(roleId);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public RolePermission findById(Integer id) {
        return rolePermissionDao.findById(id);
    }

    /**
     * 根据条件修改
     *
     * @param rolePermission
     * @return
     */
    @Override
    public int modify(RolePermission rolePermission) {
        return rolePermissionDao.update(rolePermission);
    }

    /**
     * 保存
     *
     * @param rolePermission
     * @return
     */
    @Override
    public int save(RolePermission rolePermission) {
        EntityUtil.baseSave(rolePermission);
        return rolePermissionDao.insert(rolePermission);
    }

    @Override
    public int save(Integer roleId, String[] permissions) {
        int count = 0;
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(String.valueOf(roleId));
        this.removeByRoleId(roleId);
        for (int i = 0; i < permissions.length; i++) {
            rolePermission.setPermission(permissions[i]);
            count += this.save(rolePermission);
        }
        return count;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int remove(Integer id) {
        return rolePermissionDao.delete(id);
    }

    /**
     * 根据roleId删除
     *
     * @param roleId
     * @return
     */
    @Override
    public int removeByRoleId(Integer roleId) {
        return rolePermissionDao.deleteByRoleId(roleId);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public int batchRemove(Integer[] ids) {
        return rolePermissionDao.batchDelete(ids);
    }
}
