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
@Repository
public interface MenuService {

    List<Menu> listAllMenu();

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

    String listTreeMenu(Role role, int type);
}
