package com.nxd.ftt.controller.websocket;

import com.alibaba.fastjson.JSONObject;
import com.nxd.ftt.entity.WebSocket;
import com.nxd.ftt.enumtype.WebSocketEnum;
import com.nxd.ftt.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * SystemWebSocketHandler
 * <p>
 * 处理类
 * 服务器如何处理WebSocket请求在这里面填写
 *
 * @author luhangqi
 * @date 2017/11/15
 */
public class SystemWebSocketHandler implements WebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);

    /**
     * 成功建立连接
     *
     * @param webSocketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        Object userCode = webSocketSession.getAttributes().get(Const.WEBSOCKET_USER_CODE);
        if (userCode != null) {
            WebSocketUtils.add(userCode.toString(), webSocketSession);
        }
    }

    /**
     * 接收到消息处理
     *
     * @param webSocketSession
     * @param webSocketMessage
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        //获取接收到的消息
        Object obj = webSocketMessage.getPayload();
        Object userCode = webSocketSession.getAttributes().get(Const.WEBSOCKET_USER_CODE);
        boolean b = WebSocketUtils.hasConnection(String.valueOf(userCode));
        try {
            JSONObject jsonObject = JSONObject.parseObject(obj.toString());
//            System.out.println("webSocketMessage——" + jsonObject.toJSONString());
            if (jsonObject != null && jsonObject.containsKey("cmd") && jsonObject.getString("cmd") != null) {
                String cmd = jsonObject.getString("cmd");
                if (WebSocketEnum.WS_CMD_HEARTBEAT.getCmd().equals(cmd)) {
                    WebSocket webSocket = new WebSocket();
                    webSocket.setCmd(WebSocketEnum.WS_CMD_HEARTBEAT.getCmd());
                    webSocket.setData("ftt");
                    WebSocketUtils.sendMessageToOwn(webSocketSession.getAttributes().get(Const.WEBSOCKET_USER_CODE).toString(), webSocket.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 处理异常
     *
     * @param webSocketSession
     * @param throwable
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if (webSocketSession.isOpen()) {
            logger.info("======================================================");
            logger.info("webSocket异常，关闭连接");
            logger.info("======================================================");
            webSocketSession.close();
        }
    }

    /**
     * 连接关闭后
     *
     * @param webSocketSession
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        //获取用户code
        Object userCode = webSocketSession.getAttributes().get(Const.WEBSOCKET_USER_CODE);
        if (!StringUtils.isEmpty(userCode)) {
            //从在线用户列表中移除当前用户
            WebSocketUtils.remove(String.valueOf(userCode));
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
