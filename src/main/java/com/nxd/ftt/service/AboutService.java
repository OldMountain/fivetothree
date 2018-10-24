package com.nxd.ftt.service;

import com.nxd.ftt.entity.About;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * AboutService
 *
 * @author luhangqi
 * @date 2018/10/24
 */
@Repository
public interface AboutService {


    /**
     * 查询列表
     * @return
     */
    List<About> listAll();

    /**
     * 根据条件查询列表
     * @param about
     * @return
     */
    List<About> list(About about);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    About findById(Integer id);

    /**
     * 根据条件修改
     * @param about
     * @return
     */
    int modify(About about);

    /**
     * 保存
     * @param about
     * @return
     */
    int save(About about);

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