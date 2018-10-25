package com.nxd.ftt.service.impl;

import com.nxd.ftt.dao.UserDao;
import com.nxd.ftt.entity.User;
import com.nxd.ftt.service.UserService;
import com.nxd.ftt.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author luhangqi
 * @date 2018/10/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<PageData> getList(PageData pd) {
        return null;
    }

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<User> listAll() {
       return userDao.list(new User());
    }

    /**
     * 根据条件查询列表
     * @param user
     * @return
     */
    @Override
    public List<User> list(User user) {
       return userDao.list(user);
    }

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    @Override
    public User findById(String userId) {
       return userDao.findById(userId);
    }

    /**
     * 根据条件修改
     * @param user
     * @return
     */
    @Override
    public int modify(User user) {
       return userDao.update(user);
    }

    /**
     * 保存
     * @param user
     * @return
     */
    @Override
    public int save(User user) {
       return userDao.insert(user);
    }

    /**
     * 根据userId删除
     * @param userId
     * @return
     */
    @Override
    public int remove(String userId) {
       return userDao.delete(userId);
    }

    /**
     * 批量删除
     * @param userIds
     * @return
     */
    @Override
    public int batchRemove(String[] userIds) {
       return userDao.batchDelete(userIds);
    }

    @Override
    public User login(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        List<User> list = userDao.list(user);
        if(list != null && list.size() == 1){
            return list.get(0);
        }else{
            return null;
        }
    }
}
