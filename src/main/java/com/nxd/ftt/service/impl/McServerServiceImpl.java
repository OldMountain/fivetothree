package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.McServerDao;
import com.nxd.ftt.entity.McServer;
import com.nxd.ftt.service.McServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * McServerServiceImpl
 *
 * @author luhangqi
 * @date 2018/10/24
 */
@Service
public class McServerServiceImpl implements McServerService {

    @Autowired
    private McServerDao mcServerDao;

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<McServer> listAll() {
       return mcServerDao.list(new McServer());
    }

    /**
     * 根据条件查询列表
     * @param mcServer
     * @return
     */
    @Override
    public List<McServer> list(McServer mcServer) {
       return mcServerDao.list(mcServer);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public McServer findById(Integer id) {
       return mcServerDao.findById(id);
    }

    /**
     * 根据条件修改
     * @param mcServer
     * @return
     */
    @Override
    public int modify(McServer mcServer) {
       return mcServerDao.update(mcServer);
    }

    /**
     * 保存
     * @param mcServer
     * @return
     */
    @Override
    public int save(McServer mcServer) {
       return mcServerDao.insert(mcServer);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int remove(Integer id) {
       return mcServerDao.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchRemove(Integer[] ids) {
       return mcServerDao.batchDelete(ids);
    }
}
