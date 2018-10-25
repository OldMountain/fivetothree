package com.nxd.ftt.service;

import com.nxd.ftt.entity.User;
import com.nxd.ftt.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserService
 *
 * @author luhangqi
 * @date 2018/10/25
 */
public interface UserService {

    List<PageData> getList(PageData pd);

    /**
     * 查询列表
     *
     * @return
     */
    List<User> listAll();

    /**
     * 根据条件查询列表
     *
     * @param user
     * @return
     */
    List<User> list(User user);

    /**
     * 根据userId查询
     *
     * @param userId
     * @return
     */
    User findById(String userId);

    /**
     * 根据条件修改
     *
     * @param user
     * @return
     */
    int modify(User user);

    /**
     * 保存
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 根据userId删除
     *
     * @param userId
     * @return
     */
    int remove(String userId);

    /**
     * 批量删除
     *
     * @param userIds
     * @return
     */
    int batchRemove(String[] userIds);

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);
}