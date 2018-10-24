package com.nxd.ftt.dao;

import com.nxd.ftt.entity.About;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AboutDao
 *
 * @author luhangqi
 * @date 2018/10/24
 */
public interface AboutDao {

    /**
     * 查询
     * @param about
     * @return
     */
    List<About> list(About about);

    /**
     * 查询
     * @param id
     * @return
     */
    About findById(Integer id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param about
    * @return
    */
    int insert(About about);

    /**
    * 更新
    * @param about
    * @return
    */
    int update(About about);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);
}