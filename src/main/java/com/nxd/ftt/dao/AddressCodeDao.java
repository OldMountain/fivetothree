package com.nxd.ftt.dao;

import com.nxd.ftt.entity.AddressCode;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AddressCodeDao
 *
 * @author luhangqi
 * @date 2018/10/26
 */
public interface AddressCodeDao {

    /**
     * 查询
     * @param addressCode
     * @return
     */
    List<AddressCode> list(AddressCode addressCode);

    /**
     * 查询
     * @param id
     * @return
     */
    AddressCode findById(Integer id);

    /**
    * 批量删除
    * @param id
    * @return
    */
    int batchDelete(Integer[] id);

    /**
    * 插入
    * @param addressCode
    * @return
    */
    int insert(AddressCode addressCode);

    /**
    * 更新
    * @param addressCode
    * @return
    */
    int update(AddressCode addressCode);

    /**
    * 根据id删除
    * @param id
    * @return
    */
    int delete(Integer id);
}