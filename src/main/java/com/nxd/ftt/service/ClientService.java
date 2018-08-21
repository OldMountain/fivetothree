package com.nxd.ftt.service;

import com.nxd.ftt.entity.Client;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * ClientService
 *
 * @author luhangqi
 * @date 2018/05/29
 */
@Repository
public interface ClientService {


    /**
     * 查询列表
     * @return
     * @throws SQLException
     */
    List<Client> listAll() throws SQLException;

    /**
     * 根据条件查询列表
     * @param client
     * @return
     * @throws SQLException
     */
    List<Client> list(Client client) throws SQLException;

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws SQLException
     */
    Client findById(Integer id) throws SQLException;

    /**
     * 根据条件修改
     * @param client
     * @return
     * @throws SQLException
     */
    int modify(Client client) throws SQLException;

    /**
     * 保存
     * @param client
     * @return
     * @throws SQLException
     */
    int save(Client client) throws SQLException;

    /**
     * 根据id删除
     * @param id
     * @return
     * @throws SQLException
     */
    int remove(Integer id) throws SQLException;

    /**
     * 批量删除
     * @param ids
     * @return
     * @throws SQLException
     */
    int batchRemove(Integer[] ids) throws SQLException;
}