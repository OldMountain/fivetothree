package com.nxd.ftt.dao;

import com.nxd.ftt.entity.User;
import com.nxd.ftt.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 查询
     *
     * @param user
     * @return int
     */
    List<User> select(User user);

    /**
     * 批量删除
     *
     * @param userId
     * @return int
     */
    int batchDelete(String[] userId);

    /**
     * 根据userId插入
     *
     * @param user
     * @return int
     */
    int insert(User user);

    /**
     * 根据userId更新
     *
     * @param user
     * @return int
     */
    int update(User user);

    /**
     * 根据userId删除
     *
     * @param userId
     * @return int
     */
    int delete(String userId);

    List<PageData> selectAll(PageData pd);
}