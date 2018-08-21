package com.nxd.ftt.dao;

import com.nxd.ftt.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClientDao
 *
 * @author luhangqi
 * @date 2018/05/29
 */
@Repository
public interface ClientDao {

    /**
     * 查询
     * @param client
     * @return
     */
    List<Client> select(Client client);

    /**
     * 查询
     * @param id
     * @return
     */
    Client selectById(Integer id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param client
    * @return
    */
    int insert(Client client);

    /**
    * 更新
    * @param client
    * @return
    */
    int update(Client client);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);
}