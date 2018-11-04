package com.nxd.ftt.entity;

import com.nxd.ftt.controller.base.BaseEntity;

import java.util.List;

public class Menu extends BaseEntity {
    /**
     * @mbg.generated 2017-12-04
     */
    private Integer menuId;

    /**
     * @mbg.generated 2017-12-04
     */
    private String menuName;

    /**
     * @mbg.generated 2017-12-04
     */
    private String menuUrl;

    /**
     * @mbg.generated 2017-12-04
     */
    private String parentId;

    /**
     * 上级菜单名称
     *
     * @mbg.generated 2017-12-04
     */
    private String parentName;

    /**
     * @mbg.generated 2017-12-04
     */
    private Integer menuOrder;

    /**
     * @mbg.generated 2017-12-04
     */
    private String menuIcon;

    /**
     * @mbg.generated 2017-12-04
     */
    private String menuType;

    private String target;

    private Menu parentMenu;
    private List<Menu> subMenu;

    private boolean hasMenu = false;

    /**
     * @return MENU_ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * @return MENU_NAME
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * @return MENU_URL
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * @param menuUrl
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * @return PARENT_ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * @return MENU_ORDER
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * @param menuOrder
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * @return MENU_ICON
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * @param menuIcon
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    /**
     * @return MENU_TYPE
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * @param menuType
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getTarget() {
        return target;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public boolean isHasMenu() {
        return hasMenu;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    public void setHasMenu(boolean hasMenu) {
        this.hasMenu = hasMenu;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}