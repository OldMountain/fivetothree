package com.nxd.ftt.dao;

import com.nxd.ftt.entity.Dictionary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DictionaryDao
 *
 * @author luhangqi
 * @date 2018/10/24
 */
public interface DictionaryDao {

    /**
     * 查询
     * @param dictionary
     * @return
     */
    List<Dictionary> list(Dictionary dictionary);

    /**
     * 查询
     * @param id
     * @return
     */
    Dictionary findById(Integer id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param dictionary
    * @return
    */
    int insert(Dictionary dictionary);

    /**
    * 更新
    * @param dictionary
    * @return
    */
    int update(Dictionary dictionary);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);
}