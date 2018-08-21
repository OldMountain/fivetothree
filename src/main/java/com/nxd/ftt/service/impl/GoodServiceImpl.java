package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.GoodDao;
import com.nxd.ftt.entity.Good;
import com.nxd.ftt.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * GoodServiceImpl
 *
 * @author luhangqi
 * @date 2018/05/30
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    /**
     * 查询列表
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Good> listAll() throws SQLException {
        return goodDao.select(new Good());
    }

    /**
     * 根据条件查询列表
     *
     * @param good
     * @return
     * @throws SQLException
     */
    @Override
    public List<Good> list(Good good) throws SQLException {
        return goodDao.select(good);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Good findById(Integer id) throws SQLException {
        return goodDao.selectById(id);
    }

    /**
     * 根据条件修改
     *
     * @param good
     * @return
     * @throws SQLException
     */
    @Override
    public int modify(Good good) throws SQLException {
        return goodDao.update(good);
    }

    /**
     * 保存
     *
     * @param good
     * @return
     * @throws SQLException
     */
    @Override
    public int save(Good good) throws SQLException {
        return goodDao.insert(good);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int remove(Integer id) throws SQLException {
        return goodDao.delete(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     * @throws SQLException
     */
    @Override
    public int batchRemove(Integer[] ids) throws SQLException {
        return goodDao.batchDelete(ids);
    }
}
