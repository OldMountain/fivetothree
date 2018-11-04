package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.PermissionDao;
import com.nxd.ftt.entity.system.Permission;
import com.nxd.ftt.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PermissionServiceImpl
 *
 * @author luhangqi
 * @date 2018/11/04
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<Permission> listAll() {
       return permissionDao.list(new Permission());
    }

    /**
     * 根据条件查询列表
     * @param permission
     * @return
     */
    @Override
    public List<Permission> list(Permission permission) {
       return permissionDao.list(permission);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Permission findById(Integer id) {
       return permissionDao.findById(id);
    }

    /**
     * 根据条件修改
     * @param permission
     * @return
     */
    @Override
    public int modify(Permission permission) {
       return permissionDao.update(permission);
    }

    /**
     * 保存
     * @param permission
     * @return
     */
    @Override
    public int save(Permission permission) {
       return permissionDao.insert(permission);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int remove(Integer id) {
       return permissionDao.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchRemove(Integer[] ids) {
       return permissionDao.batchDelete(ids);
    }
}
