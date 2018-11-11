package com.nxd.ftt.util;


import org.springframework.context.ApplicationContext;

/**
 * 项目名称：
 *
 * @author:nxd
 */
public class Const {

    public static final String SESSION_SECURITY_CODE = "sessionCode";
    public static final String SESSION_USER = "sessionUser";
    public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
    public static final String SESSION_menuList = "menuList";            //当前菜单
    public static final String SESSION_allmenuList = "allmenuList";        //全部菜单
    public static final String SESSION_QX = "QX";
    public static final String SESSION_userpds = "userpds";
    public static final String SESSION_USERROL = "USERROL";                //用户对象
    public static final String SESSION_USERNAME = "USERNAME";            //用户名
    public static final String TRUE = "T";
    public static final String FALSE = "F";
    public static final String LOGIN = "/toLogin.do";                //登录地址
    public static final String SYSNAME = "admin/config/SYSNAME.txt";    //系统名称路径
    public static final String PAGE = "admin/config/PAGE.txt";            //分页条数配置路径
    public static final String EMAIL = "admin/config/EMAIL.txt";        //邮箱服务器配置路径
    public static final String SMS1 = "admin/config/SMS1.txt";            //短信账户配置路径1
    public static final String SMS2 = "admin/config/SMS2.txt";            //短信账户配置路径2
    public static final String FWATERM = "admin/config/FWATERM.txt";    //文字水印配置路径
    public static final String IWATERM = "admin/config/IWATERM.txt";    //图片水印配置路径
    public static final String WEIXIN = "admin/config/WEIXIN.txt";    //微信配置路径
    public static final String FILEPATHIMG = "uploadFiles/uploadImgs/";    //图片上传路径

    /**
     * 项目路径
     */
    public static final String CONTEXT_PATH = "ctx";


    /**
     * 常用常量
     */
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";


    /**
     * 图片虚拟目录
     */
    public static final String PICTURE_DIR = PropertiesUtils.findPropertiesKey("load.picture");
    /**
     * 图片根目录
     */
    public static final String PICTURE_ROOT_DIR = PropertiesUtils.findPropertiesKey("upload.picture");

    /**
     * 文件根目录
     */
    public static final String FILE_ROOT_DIR = PropertiesUtils.findPropertiesKey("upload.file");

    /**
     * 图片上传路径
     */
    public static final String PICTURE_ROOMTYPE_PATH = "uploadFiles/uploadImgs/roomtype/";
    //	public static final String FILE_PATH_IMG_ROOM_TYPE = PropertiesUtils.findPropertiesKey("upload.picture") + "uploadFiles/uploadImgs/roomtype/";
    public static final String FILEPATHFILE = "uploadFiles/file/";        //文件上传路径
    public static final String FILE_PATHFILE_ftt = "uploadFiles/file/ftt/";        //文件上传路径
    public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/"; //二维码存放路径
    public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(toLogin)|(toIndex)|(code)|(pages)|(page)|(static)|(plugins)|(uploadFiles)|(wechat)|(picture)|(api)).*";    //不对匹配该值的访问路径拦截（正则）


    public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化

    // 项目的token
    public static final String PROJECT_AUTH_TOKEN = PropertiesUtils.findPropertiesKey("project.auth.Token");


    /**
     * 系统管理员
     */
    public static final Integer ADMIN_ROLE_ID = -1;
    public static final String ADMIN = "admin";

    //分页
    //每页显示数量
    public static final int PAGE_SIZE = 10;


    /**
     * 验证码保存时间，单位秒
     */
    public static final Long CODE_TIME = 120L;


    /**
     * 支付相关
     */
    public static final String PINGPP_APIKEY = PropertiesUtils.findPropertiesKey("Pingpp.apiKey");
    public static final String PINGPP_APPID = PropertiesUtils.findPropertiesKey("Pingpp.appID");
    public static final String PINGPP_PUBLICKEY = PropertiesUtils.findPropertiesKey("Pingpp.publicKey");
    public static String PINGPP_SUCCESS_URL = "https://example.com/success";
    public static String PINGPP_CANCEL_URL = "https://example.com/cancel";

    public static String SYNCHRONIZE = PropertiesUtils.findPropertiesKey("synchronize");
    public static String AUTHORIZATION = PropertiesUtils.findPropertiesKey("authorization");

    /**
     * 支付宝
     */
    public static final String ALIPAY_SERVER_URL = PropertiesUtils.findPropertiesKey("alipay.serverUrl");
    public static final String ALIPAY_APP_ID = PropertiesUtils.findPropertiesKey("alipay.appId");
    public static final String ALIPAY_APP_PRIVATE_KEY = PropertiesUtils.findPropertiesKey("alipay.appPrivateKey");
    public static final String ALIPAY_ALIPAY_PUBLIC_KEY = PropertiesUtils.findPropertiesKey("alipay.alipayPublicKey");
    public static final String ALIPAY_SIGN_TYPE = PropertiesUtils.findPropertiesKey("alipay.signType");
    public static String ALIPAY_SUCCESS_URL = "http://192.168.0.20:8089/pmswechat/book-suc.html";
    public static final String ALIPAY_NOTIFY_URL = PropertiesUtils.findPropertiesKey("alipay.notify.url");

    public static final String nxd_SPLIT = "#nxd523#";

    //websocket
    public static final String WEBSOCKET_USER_CODE = "webSocketUserCode";
    //websocket获取指定用户的键
    public static final String WEBSOCKET_USERCODE = "userCode";

    //WebSocketSession的sessionId标识
    public static final String WEBSOCKET_USERCODE_DEFAULT = "defaultSystem";
    //WebSocketSession的sessionId标识
    public static final String WEBSOCKET_EMPNO = "fivetothree";

    //调用邮件接口的key
    public static final String EMAIL_KEY = PropertiesUtils.findPropertiesKey("email.key");

    public static final String SERVER_INFO_CACHE = "ServerInfoCache";

    /**
     * 菜单树 根目录名称
     */
    public static final String ROOT_MENU_NAME = "全部菜单";

    /**
     * 用户权限
     */
    public static final String USER_ALL_PERMISSION = "USER_ALL_PERMISSION";

    /**
     * 首页
     */
    public static final String INDEX_URL_KEY = "indexUrl";
    public static final String INDEX_URL = "system/console";
}
