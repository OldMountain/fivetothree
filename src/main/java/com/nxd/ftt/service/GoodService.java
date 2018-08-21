package com.nxd.ftt.service;

import com.nxd.ftt.entity.Good;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * GoodService
 *
 * @author luhangqi
 * @date 2018/05/30
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public interface GoodService {


    /**
     * 查询列表
     *
     * @return
     * @throws SQLException
     */
    List<Good> listAll() throws SQLException;

    /**
     * 根据条件查询列表
     *
     * @param good
     * @return
     * @throws SQLException
     */
    List<Good> list(Good good) throws SQLException;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     * @throws SQLException
     */
    Good findById(Integer id) throws SQLException;

    /**
     * 根据条件修改
     *
     * @param good
     * @return
     * @throws SQLException
     */
    int modify(Good good) throws SQLException;

    /**
     * 保存
     *
     * @param good
     * @return
     * @throws SQLException
     */
    int save(Good good) throws SQLException;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws SQLException
     */
    int remove(Integer id) throws SQLException;

    /**
     * 批量删除
     *
     * @param ids
     * @return
     * @throws SQLException
     */
    int batchRemove(Integer[] ids) throws SQLException;
}