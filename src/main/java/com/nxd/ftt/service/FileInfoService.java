package com.nxd.ftt.service;

import com.nxd.ftt.entity.FileInfo;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * FileInfoService
 *
 * @author OldMountain
 * @date 2018/06/12
 */
@Repository
public interface FileInfoService {


    /**
     * 查询列表
     * @return
     * @throws SQLException
     */
    List<FileInfo> listAll() throws SQLException;

    /**
     * 根据条件查询列表
     * @param fileInfo
     * @return
     * @throws SQLException
     */
    List<FileInfo> list(FileInfo fileInfo) throws SQLException;

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws SQLException
     */
    FileInfo findById(String id) throws SQLException;

    /**
     * 根据条件修改
     * @param fileInfo
     * @return
     * @throws SQLException
     */
    int modify(FileInfo fileInfo) throws SQLException;

    /**
     * 保存
     * @param fileInfo
     * @return
     * @throws SQLException
     */
    int save(FileInfo fileInfo) throws SQLException;

    /**
     * 根据id删除
     * @param id
     * @return
     * @throws SQLException
     */
    int remove(String id) throws SQLException;

    /**
     * 批量删除
     * @param ids
     * @return
     * @throws SQLException
     */
    int batchRemove(String[] ids) throws SQLException;
}