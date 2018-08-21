package com.nxd.ftt.controller.websocket;

import com.nxd.ftt.entity.User;
import com.nxd.ftt.util.Const;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocketUtils
 * <p>
 * webSocket工具类
 *
 * @author luhangqi
 * @date 2017/11/15
 */
public class WebSocketUtils {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketUtils.class);

    private static Map<String, WebSocketSession> clients = new ConcurrentHashMap<>();

    /**
     * 保存一个连接
     *
     * @param codeId
     * @param session
     */
    public static void add(String codeId, WebSocketSession session) {
        clients.put(codeId, session);
    }

    /**
     * 获取一个连接
     *
     * @param userCode
     * @return
     */
    public static WebSocketSession get(String userCode) {
        return clients.get(userCode);
    }

    /**
     * 移除指定的连接
     *
     * @param codeId
     */
    public static void remove(String codeId) throws IOException {
        clients.remove(codeId);
    }

    /**
     * 判断是否有效连接
     * 判断是否存在
     * 判断连接是否开启
     * 无效的进行清除
     *
     * @param codeId
     * @return
     */
    public static boolean hasConnection(String codeId) {
        boolean flag = false;
        if (clients.containsKey(codeId)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 给指定用户发送链接
     *
     * @param userCode
     * @param message
     */
    public static void sendMessageToOwn(String userCode, String message) {
        if (hasConnection(userCode)) {
            WebSocketSession session = get(userCode);
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("websocket sendMessage exception: " + userCode);
            }
        }
    }

    /**
     * 给指定用户发送链接
     *
     * @param userName
     * @param message
     */
    public static void sendMessageToUser(String message, String userName) {
        Set<String> keys = clients.keySet();
        for (String key : keys) {
            if (key.startsWith(userName)) {
                sendMessageToOwn(key, message);
            }
        }
    }

    /**
     * 给指定用户发送链接
     *
     * @param message
     */
    public static void sendMessageToUser(String message) {
        String userName;
        Session session = SecurityUtils.getSubject().getSession();
        Object obj = session.getAttribute(Const.SESSION_USER);
        if (obj != null) {
            User user = (User) obj;
            userName = user.getUserName();
        } else {
            return;
        }
        Set<String> keys = clients.keySet();
        for (String key : keys) {
            if (key.startsWith(userName)) {
                sendMessageToOwn(key, message);
            }
        }
    }

    public static void sendMessageToAll(String message) {
        for (WebSocketSession session : clients.values()) {
            if (session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("websocket sendMessage exception: " + session.getAttributes().get(Const.WEBSOCKET_USER_CODE));
                }
            }
        }
    }
}
