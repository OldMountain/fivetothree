package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.ClientDao;
import com.nxd.ftt.entity.Client;
import com.nxd.ftt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * ClientServiceImpl
 *
 * @author luhangqi
 * @date 2018/05/29
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    /**
     * 查询列表
     * @return
     * @throws SQLException
     */
    @Override
    public List<Client> listAll() throws SQLException {
       return clientDao.select(new Client());
    }

    /**
     * 根据条件查询列表
     * @param client
     * @return
     * @throws SQLException
     */
    @Override
    public List<Client> list(Client client) throws SQLException {
       return clientDao.select(client);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Client findById(Integer id) throws SQLException {
       return clientDao.selectById(id);
    }

    /**
     * 根据条件修改
     * @param client
     * @return
     * @throws SQLException
     */
    @Override
    public int modify(Client client) throws SQLException {
       return clientDao.update(client);
    }

    /**
     * 保存
     * @param client
     * @return
     * @throws SQLException
     */
    @Override
    public int save(Client client) throws SQLException {
       return clientDao.insert(client);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int remove(Integer id) throws SQLException {
       return clientDao.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     * @throws SQLException
     */
    @Override
    public int batchRemove(Integer[] ids) throws SQLException {
       return clientDao.batchDelete(ids);
    }
}
