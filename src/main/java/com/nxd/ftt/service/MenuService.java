package com.nxd.ftt.service;

import com.nxd.ftt.entity.Menu;
import com.nxd.ftt.entity.Role;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * MenuService
 *
 * @author OldMountain
 * @date 2017/12/4
 */
public interface MenuService {

    /**
     * 获取所有菜单
     * @return
     */
    List<Menu> listAllMenu();

    /**
     * 获取当前用户菜单
     * @return
     */
    List<Menu> getCurrentUserMenu();

    /**
     * 查询所有父级菜单
     * @return
     * @throws SQLException
     */
    List<Menu> listParentAll();

    /**
     * 查询所有子菜单
     * @param menuId
     * @return
     * @throws SQLException
     */
    List<Menu> selectSubMenuByParentId(String menuId);

    /**
     * 获取菜单树
     * @param role
     * @param type
     * @return
     */
    String listTreeMenu(Role role, int type);

    /**
     * 根据ID 查询菜单
     * @param menuId
     * @return
     */
    Menu findById(Integer menuId);

    /**
     * 保存菜单
     * @param menu
     * @return
     */
    int save(Menu menu);

    /**
     * 根据父ID 查询最大排序
     * @param parentId
     * @return
     */
    int findMaxOrder(Integer parentId);
}
