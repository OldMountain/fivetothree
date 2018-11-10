package com.nxd.ftt.entity;

/**
 * Tree
 *
 * @author luhangqi
 * @date 2018/10/28
 */
public class Tree {

    private String id;
    private String pId;
    private String name;
    private boolean checked;
    private boolean open;
    private String type;

    public Tree() {
    }

    public Tree(String id, String pId, String name, boolean checked) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.checked = checked;
    }

    public Tree(String id, String pId, String name, boolean checked, boolean open) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.checked = checked;
        this.open = open;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
