package com.nxd.ftt.controller.base;

import com.google.gson.Gson;

/**
 * BaseEntity
 *
 * @author OldMountain
 * @date 2017/12/4
 */
public class BaseEntity {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
