package com.nxd.ftt.util;

import com.nxd.ftt.entity.BaseEntity;

import java.util.Date;

/**
 * EntityUtil
 *
 * @author luhangqi
 * @date 2018/11/8
 */
public class EntityUtil {

    public static <T extends BaseEntity> void baseSave(T entity) {
        entity.setCreateor(SystemUtil.getCurrentUser().getUserId());
        entity.setUpdateor(entity.getCreateor());
        entity.setCreateTime(new Date());
        entity.setUpdateTime(entity.getCreateTime());
    }
}
