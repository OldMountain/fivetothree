package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.FileInfoDao;
import com.nxd.ftt.entity.FileInfo;
import com.nxd.ftt.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * FileInfoServiceImpl
 *
 * @author OldMountain
 * @date 2018/06/12
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoDao fileInfoDao;

    /**
     * 查询列表
     * @return
     * @throws SQLException
     */
    @Override
    public List<FileInfo> listAll() throws SQLException {
       return fileInfoDao.select(new FileInfo());
    }

    /**
     * 根据条件查询列表
     * @param fileInfo
     * @return
     * @throws SQLException
     */
    @Override
    public List<FileInfo> list(FileInfo fileInfo) throws SQLException {
       return fileInfoDao.select(fileInfo);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public FileInfo findById(String id) throws SQLException {
       return fileInfoDao.selectById(id);
    }

    /**
     * 根据条件修改
     * @param fileInfo
     * @return
     * @throws SQLException
     */
    @Override
    public int modify(FileInfo fileInfo) throws SQLException {
       return fileInfoDao.update(fileInfo);
    }

    /**
     * 保存
     * @param fileInfo
     * @return
     * @throws SQLException
     */
    @Override
    public int save(FileInfo fileInfo) throws SQLException {
       return fileInfoDao.insert(fileInfo);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int remove(String id) throws SQLException {
       return fileInfoDao.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     * @throws SQLException
     */
    @Override
    public int batchRemove(String[] ids) throws SQLException {
       return fileInfoDao.batchDelete(ids);
    }
}
