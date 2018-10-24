package com.nxd.ftt.dao;

import com.nxd.ftt.entity.McServer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * McServerDao
 *
 * @author luhangqi
 * @date 2018/10/24
 */
public interface McServerDao {

    /**
     * 查询
     * @param mcServer
     * @return
     */
    List<McServer> list(McServer mcServer);

    /**
     * 查询
     * @param id
     * @return
     */
    McServer findById(Integer id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param mcServer
    * @return
    */
    int insert(McServer mcServer);

    /**
    * 更新
    * @param mcServer
    * @return
    */
    int update(McServer mcServer);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);
}