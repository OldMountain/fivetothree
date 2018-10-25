package com.nxd.ftt.dao;

import com.nxd.ftt.entity.User;
import com.nxd.ftt.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 *
 * @author luhangqi
 * @date 2018/10/25
 */
public interface UserDao {

    /**
     * 查询
     * @param user
     * @return
     */
    List<User> list(User user);

    /**
     * 查询
     * @param userId
     * @return
     */
    User findById(String userId);

    /**
    * 批量删除
    * @param userId
    * @return
    */
    int batchDelete(String[] userId);

    /**
    * 插入
    * @param user
    * @return
    */
    int insert(User user);

    /**
    * 更新
    * @param user
    * @return
    */
    int update(User user);

    /**
    * 根据userId删除
    * @param userId
    * @return
    */
    int delete(String userId);

}