package com.nxd.ftt.service;

import com.nxd.ftt.entity.AddressCode;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * AddressCodeService
 *
 * @author luhangqi
 * @date 2018/10/26
 */
public interface AddressCodeService {


    /**
     * 查询列表
     * @return
     */
    List<AddressCode> listAll();

    /**
     * 根据条件查询列表
     * @param addressCode
     * @return
     */
    List<AddressCode> list(AddressCode addressCode);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    AddressCode findById(Integer id);

    /**
     * 根据条件修改
     * @param addressCode
     * @return
     */
    int modify(AddressCode addressCode);

    /**
     * 保存
     * @param addressCode
     * @return
     */
    int save(AddressCode addressCode);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int remove(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchRemove(Integer[] ids);
}