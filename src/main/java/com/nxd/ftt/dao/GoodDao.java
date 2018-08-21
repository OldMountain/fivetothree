package com.nxd.ftt.dao;

import com.nxd.ftt.entity.Good;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodDao
 *
 * @author luhangqi
 * @date 2018/05/30
 */
@Repository
public interface GoodDao {

    /**
     * 查询
     * @param good
     * @return
     */
    List<Good> select(Good good);

    /**
     * 查询
     * @param id
     * @return
     */
    Good selectById(Integer id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param good
    * @return
    */
    int insert(Good good);

    /**
    * 更新
    * @param good
    * @return
    */
    int update(Good good);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);
}