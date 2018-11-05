package com.nxd.ftt.config.websocket;

import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.Tools;
import com.nxd.ftt.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * WebSocketHandshakeInterceptor
 * <p>
 * WebSocket 握手类
 *
 * @author luhangqi
 * @date 2017/11/15
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        logger.info("======================================================");
        logger.info("开始握手");
        logger.info("======================================================");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            String codeId = ((ServletServerHttpRequest) request).getServletRequest().getParameter(Const.WEBSOCKET_USERCODE);
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (Tools.isEmpty(codeId)) {
//                if (session != null) {
//                    //使用userId区分WebSocketHandler，以便定向发送消息
//                    User user = null;
//                    if(null != (user = (User) session.getAttribute(Const.SESSION_USER))){
//                        codeId = user.getUSER_ID();
//                    }
//                }else{
                codeId = Const.WEBSOCKET_USERCODE_DEFAULT;
//                }
            }
            attributes.put(Const.WEBSOCKET_USERCODE, codeId + "_" + Const.WEBSOCKET_EMPNO + "_" + UuidUtil.get32UUID());
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        logger.info("======================================================");
        logger.info("握手成功");
        logger.info("======================================================");
    }

}
