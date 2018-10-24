package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.DictionaryDao;
import com.nxd.ftt.entity.Dictionary;
import com.nxd.ftt.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * DictionaryServiceImpl
 *
 * @author luhangqi
 * @date 2018/10/24
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryDao dictionaryDao;

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<Dictionary> listAll() {
       return dictionaryDao.list(new Dictionary());
    }

    /**
     * 根据条件查询列表
     * @param dictionary
     * @return
     */
    @Override
    public List<Dictionary> list(Dictionary dictionary) {
       return dictionaryDao.list(dictionary);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Dictionary findById(Integer id) {
       return dictionaryDao.findById(id);
    }

    /**
     * 根据条件修改
     * @param dictionary
     * @return
     */
    @Override
    public int modify(Dictionary dictionary) {
       return dictionaryDao.update(dictionary);
    }

    /**
     * 保存
     * @param dictionary
     * @return
     */
    @Override
    public int save(Dictionary dictionary) {
       return dictionaryDao.insert(dictionary);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int remove(Integer id) {
       return dictionaryDao.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchRemove(Integer[] ids) {
       return dictionaryDao.batchDelete(ids);
    }
}
