package com.nxd.ftt.dao;

import com.nxd.ftt.entity.FileInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FileInfoDao
 *
 * @author OldMountain
 * @date 2018/06/12
 */
@Repository
public interface FileInfoDao {

    /**
     * 查询
     * @param fileInfo
     * @return
     */
    List<FileInfo> select(FileInfo fileInfo);

    /**
     * 查询
     * @param id
     * @return
     */
    FileInfo selectById(String id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(String[] id);

    /**
    * 插入
    * @param fileInfo
    * @return
    */
    int insert(FileInfo fileInfo);

    /**
    * 更新
    * @param fileInfo
    * @return
    */
    int update(FileInfo fileInfo);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(String id);
}