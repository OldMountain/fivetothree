package com.nxd.ftt.service;

import com.nxd.ftt.entity.McServer;
import com.nxd.ftt.mchelper.entity.server.ServerInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * McServerService
 *
 * @author luhangqi
 * @date 2018/10/24
 */
@Repository
public interface McServerService {


    /**
     * 查询列表
     *
     * @return
     */
    List<McServer> listAll();

    /**
     * 根据条件查询列表
     *
     * @param mcServer
     * @return
     */
    List<McServer> list(McServer mcServer);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    McServer findById(Integer id);

    /**
     * 根据条件修改
     *
     * @param mcServer
     * @return
     */
    int modify(McServer mcServer);

    /**
     * 保存
     *
     * @param mcServer
     * @return
     */
    int save(McServer mcServer);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int remove(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int batchRemove(Integer[] ids);

    /**
     * 获取我的世界服务器信息
     *
     * @return
     */
    ServerInfo getInfo();
}