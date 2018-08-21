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
 * @author OldMountain
 * @date 2017/12/4
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAll() throws SQLException {
        return userDao.select(new User());
    }

    @Override
    public List<User> list(User user) throws SQLException {
        return userDao.select(user);
    }

    @Override
    public List<PageData> getList(PageData pd) throws SQLException {
        return userDao.selectAll(pd);
    }

    @Override
    public User find(User user) throws SQLException {
        List<User> list = userDao.select(user);
        if(list != null && list.size() == 1){
            return userDao.select(user).get(0);
        }else{
            return null;
        }
    }

    @Override
    public int modify(User user) {
        return userDao.update(user);
    }

    @Override
    public int save(User user) {
        return userDao.insert(user);
    }

    @Override
    public int remove(User user) {
        return userDao.delete(user.getUserId());
    }

    @Override
    public int batchRemove(String[] userIds) throws SQLException {
        return userDao.batchDelete(userIds);
    }

    @Override
    public User login(String userName, String password) throws SQLException {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        List<User> list = userDao.select(user);
        if(list != null && list.size() == 1){
            return list.get(0);
        }else{
            return null;
        }
    }
}
