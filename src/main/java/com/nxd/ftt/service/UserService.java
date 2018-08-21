package com.nxd.ftt.service;

import com.nxd.ftt.entity.User;
import com.nxd.ftt.util.PageData;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * UserService
 *
 * @author OldMountain
 * @date 2017/12/4
 */
@Repository
public interface UserService {

    List<User> listAll() throws SQLException;

    List<User> list(User user) throws SQLException;

    List<PageData> getList(PageData pd) throws SQLException;

    User find(User user) throws Exception;

    int modify(User user) throws SQLException;

    int save(User user) throws SQLException;

    int remove(User user) throws SQLException;

    int batchRemove(String[] userIds) throws SQLException;

    User login(String userName, String password) throws SQLException;

}
