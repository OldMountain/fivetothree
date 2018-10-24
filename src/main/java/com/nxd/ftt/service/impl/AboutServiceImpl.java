package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.AboutDao;
import com.nxd.ftt.entity.About;
import com.nxd.ftt.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * AboutServiceImpl
 *
 * @author luhangqi
 * @date 2018/10/24
 */
@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutDao aboutDao;

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<About> listAll() {
       return aboutDao.list(new About());
    }

    /**
     * 根据条件查询列表
     * @param about
     * @return
     */
    @Override
    public List<About> list(About about) {
       return aboutDao.list(about);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public About findById(Integer id) {
       return aboutDao.findById(id);
    }

    /**
     * 根据条件修改
     * @param about
     * @return
     */
    @Override
    public int modify(About about) {
       return aboutDao.update(about);
    }

    /**
     * 保存
     * @param about
     * @return
     */
    @Override
    public int save(About about) {
       return aboutDao.insert(about);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int remove(Integer id) {
       return aboutDao.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchRemove(Integer[] ids) {
       return aboutDao.batchDelete(ids);
    }
}
