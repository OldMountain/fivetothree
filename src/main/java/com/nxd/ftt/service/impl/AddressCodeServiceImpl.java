package com.nxd.ftt.service.impl;

import com.nxd.ftt.common.entity.AddressCode;
import com.nxd.ftt.dao.AddressCodeDao;
import com.nxd.ftt.service.AddressCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AddressCodeServiceImpl
 *
 * @author luhangqi
 * @date 2018/10/26
 */
@Service
public class AddressCodeServiceImpl implements AddressCodeService {

    @Autowired
    private AddressCodeDao addressCodeDao;

    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public List<AddressCode> listAll() {
        return addressCodeDao.list(new AddressCode());
    }

    /**
     * 根据条件查询列表
     *
     * @param addressCode
     * @return
     */
    @Override
    public List<AddressCode> list(AddressCode addressCode) {
        return addressCodeDao.list(addressCode);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public AddressCode findById(Integer id) {
        return addressCodeDao.findById(id);
    }

    /**
     * 根据条件修改
     *
     * @param addressCode
     * @return
     */
    @Override
    public int modify(AddressCode addressCode) {
        return addressCodeDao.update(addressCode);
    }

    /**
     * 保存
     *
     * @param addressCode
     * @return
     */
    @Override
    public int save(AddressCode addressCode) {
        return addressCodeDao.insert(addressCode);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int remove(Integer id) {
        return addressCodeDao.delete(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public int batchRemove(Integer[] ids) {
        return addressCodeDao.batchDelete(ids);
    }
}
