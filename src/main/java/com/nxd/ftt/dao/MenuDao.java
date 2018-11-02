package com.nxd.ftt.dao;

import com.nxd.ftt.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    /**
     * 查询
     * @param menu
     * @return int
     */
    List<Menu> select(Menu menu);

    /**
     * 根据ID 查询菜单
     * @param menuId
     * @return
     */
    Menu findById(Integer menuId);

    /**
     * 批量删除
     * @param menuId
     * @return int
     */
    int batchDelete(String[] menuId);

    /**
     * 根据menuId插入
     * @param menu
     * @return int
     */
    int insert(Menu menu);

    /**
     * 根据menuId更新
     * @param menu
     * @return int
     */
    int update(Menu menu);

    /**
     * 根据menuId删除
     * @param menuId
     * @return int
     */
    int delete(String menuId);

    /**
     * 根据父ID 查询最大排序
     * @param parentId
     * @return
     */
    int findMaxOrder(Integer parentId);
}