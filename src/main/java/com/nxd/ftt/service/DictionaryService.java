package com.nxd.ftt.service;

import com.nxd.ftt.entity.Dictionary;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * DictionaryService
 *
 * @author luhangqi
 * @date 2018/10/24
 */
public interface DictionaryService {


    /**
     * 查询列表
     * @return
     */
    List<Dictionary> listAll();

    /**
     * 根据条件查询列表
     * @param dictionary
     * @return
     */
    List<Dictionary> list(Dictionary dictionary);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Dictionary findById(Integer id);

    /**
     * 根据条件修改
     * @param dictionary
     * @return
     */
    int modify(Dictionary dictionary);

    /**
     * 保存
     * @param dictionary
     * @return
     */
    int save(Dictionary dictionary);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int remove(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchRemove(Integer[] ids);
}