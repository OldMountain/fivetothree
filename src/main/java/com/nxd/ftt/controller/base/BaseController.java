package com.nxd.ftt.controller.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nxd.ftt.entity.Page;
import com.nxd.ftt.entity.Role;
import com.nxd.ftt.entity.User;
import com.nxd.ftt.entity.result.ResultPage;
import com.nxd.ftt.service.RoleService;
import com.nxd.ftt.util.Const;
import com.nxd.ftt.util.PageData;
import com.nxd.ftt.util.Tools;
import com.nxd.ftt.util.UuidUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {


    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    private static final long serialVersionUID = 6357869213649815390L;

    @Autowired
    private RoleService roleService;

    /**
     * 得到PageData
     */
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

    /**
     * 得到ModelAndView
     */
    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 得到32位的uuid
     *
     * @return
     */
    public String get32UUID() {

        return UuidUtil.get32UUID();
    }

    /**
     * 得到分页列表的信息
     */
    public Page getPage() {

        return new Page();
    }

    public static void logBefore(Logger logger, String interfaceName) {
        logger.info("");
        logger.info("start");
        logger.info(interfaceName);
    }

    public static void logAfter(Logger logger) {
        logger.info("end");
        logger.info("");
    }


    /**
     * 返回shiro管理的session
     *
     * @return
     */
    protected Session getShiroSession() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser != null ? currentUser.getSession() : null;
    }


    /**
     * 设置shiro中字段的值
     *
     * @param key
     * @param value
     */
    protected void setShiroSessionField(Object key, Object value) throws InvalidSessionException {
        if (key == null) {
            return;
        }
        Session shiroSession = this.getShiroSession();
        if (shiroSession != null) {
            shiroSession.setAttribute(key, value);
        }
    }

    /**
     * 删除shiro管理session的某些字段
     *
     * @param key 字段的key
     * @return null 则失败
     * @throws InvalidSessionException
     */
    protected Object removeShiroSessionField(Object key) throws InvalidSessionException {
        Session shiroSession = this.getShiroSession();
        return shiroSession != null ? shiroSession.removeAttribute(key) : null;
    }

    /**
     * 返回shiro管理session的某些字段
     *
     * @param key      字段的key
     * @param classOfT 字段的类型
     * @param <T>      字段的类型
     * @return
     */
    protected <T> T getShiroSessionField(String key, Class<T> classOfT) throws InvalidSessionException, ClassCastException {
        if (key == null) {
            //键为空 断言值为空
            return null;
        }
        Session shiroSession = this.getShiroSession();
        if (classOfT == null) {
            classOfT = (Class<T>) Object.class;
        }
        return shiroSession != null ? (T) shiroSession.getAttribute(key) : null;
    }

    /**
     * 返回shiro管理session的某些字段
     *
     * @param key 字段的key
     * @return
     */
    protected Object getShiroSessionField(String key) throws InvalidSessionException, ClassCastException {
        return getShiroSessionField(key, null);
    }

    /* ===============================权限================================== */
    public Map<String, String> getHC() {
        Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
        Session session = currentUser.getSession();
        return (Map<String, String>) session.getAttribute(Const.SESSION_QX);
    }
    /* ===============================权限================================== */

//	protected User getLoginUser(){
//		return getShiroSessionField(Const.SESSION_USERROL, User.class);
//	}

    /**
     * 设置返回消息
     *
     * @param state
     * @param msg
     * @return
     */
    protected Map<String, Object> setResult(boolean state, String msg, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", state);
        if (Tools.isEmpty(msg)) {
            if (state) {
                result.put("msg", "操作成功");
            } else {
                result.put("msg", "操作失败");
            }
        } else {
            result.put("msg", msg);
        }
        if (state && null != data) {
            result.put("data", data);
        }
        return result;
    }

    /**
     * 获取用户权限
     */
    public Map<String, String> getUQX(Session session) {
//        PageData pd = new PageData();
        Map<String, String> map = new HashMap<String, String>();
        User user = (User) session.getAttribute(Const.SESSION_USER);
        Role role = new Role();
        role.setRoleId(user.getRoleId());
        try {
            String USERNAME = session.getAttribute(Const.SESSION_USERNAME).toString();
//            pd.put(Const.SESSION_USERNAME, USERNAME);
//            String ROLE_ID = userService.findByUId(pd).get("ROLE_ID").toString();
//
//            pd.put("ROLE_ID", ROLE_ID);

            Role roleModel = roleService.getRoleById(role);

            map.put("adds", roleModel.getAddQx());
            map.put("dels", roleModel.getDelQx());
            map.put("edits", roleModel.getEditQx());
            map.put("chas", roleModel.getChaQx());

            //System.out.println(map);
            //TODO 暂时不更新ip
//			this.getRemortIP(USERNAME);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return map;
    }

    protected String getPageStr(Object obj) {
//		PageInfo<CustomerModel> page = new PageInfo<>(list);
        com.github.pagehelper.Page page = (com.github.pagehelper.Page) obj;
        StringBuffer sb = new StringBuffer();
        if (page.getTotal() > 0 && page.getPages() > 1) {
            sb.append("	<ul class=\"pagination\">\n");
            if (page.getPageNum() == 1) {
                sb.append(" <li class=\"disabled\"><a style='background-color:#606060' href=\"javascript:void(0);\">共" + page.getTotal() + "条</a></li>\n");
                sb.append(" <li class=\"disabled\"><a style='background-color:#2890E0' href=\"javascript:void(0);\">首页</a></li>\n");
            } else {
                sb.append(" <li class=\"disabled\"><a style='background-color:#606060' href=\"javascript:void(0);\">共" + page.getTotal() + "条</a></li>\n");
                sb.append(" <li><a style='background-color:#2890E0' href=\"javascript:void(0);\" onclick=\"toGoPage(1," + page.getPageSize() + ")\">首页</a></li>\n");
            }
            int showTag = 5;//分页标签显示数量
            int startTag = 1;
            if (page.getPageNum() >= showTag - 2 && page.getPageNum() < page.getPages() - 2) {
                startTag = page.getPageNum() - 2;
            } else if (page.getPageNum() >= page.getPages() - 2 && page.getPages() > showTag) {
                startTag = page.getPages() - showTag + 1;
            }
            int endTag = startTag + showTag - 1;
            for (int i = startTag; i <= page.getPages() && i <= endTag; i++) {
                if (page.getPageNum() == i) {
                    sb.append(" <li class=\"active disabled\"><a href=\"javascript:void(0);\">" + i + "</a></li>\n");
                } else {
                    sb.append(" <li><a href=\"javascript:void(0);\" onclick=\"toGoPage(" + i + "," + page.getPageSize() + ")\">" + i + "</a></li>\n");
                }
            }
            if (page.getPageNum() == page.getPages()) {
                sb.append(" <li class=\"disabled\"><a href=\"javascript:void(0);\" style='background-color:#2890E0'>尾页</a></li>\n");
                sb.append(" <li class=\"disabled\"><a href=\"javascript:void(0);\">共" + page.getPages() + "页</a></li>\n");
                sb.append("	<li><select class=\"pageSize\" title='显示条数' style=\"width:55px;float:left;height:32px;padding:0px;\" onchange=\"toGoPage(1,this.value)\">\n");
                sb.append("	<option value='10'>10</option>\n");
                sb.append("	<option value='20'>20</option>\n");
                sb.append("	<option value='30'>30</option>\n");
                sb.append("	<option value='40'>40</option>\n");
                sb.append("	<option value='50'>50</option>\n");
                sb.append("	<option value='60'>60</option>\n");
                sb.append("	<option value='70'>70</option>\n");
                sb.append("	<option value='80'>80</option>\n");
                sb.append("	<option value='90'>90</option>\n");
                sb.append("	<option value='100'>100</option>\n");
                sb.append("	</select>\n");
                sb.append("	</li>\n");
                sb.append(" <li class=\"\"><input id='jumpPage' class='ftt-input' style=\"width:55px;float:left;height:32px;padding:0px;border-radius:5px;\" type='number' value='" + page.getPageNum() + "' /></li>\n");
                sb.append(" <li class=\"\"><a href=\"javascript:void(0);\" style='background-color:#2890E0' onclick=\"toJumpPage(this," + page.getPageSize() + ")\">跳转</a></li>\n");
            } else {
                sb.append(" <li><a href=\"javascript:void(0);\" style='background-color:#2890E0' onclick=\"toGoPage(" + page.getPages() + "," + page.getPageSize() + ")\">尾页</a></li>\n");
                sb.append(" <li class=\"disabled\"><a href=\"javascript:void(0);\">共" + page.getPages() + "页</a></li>\n");
                sb.append("	<li><select class=\"pageSize\" title='显示条数' style=\"width:55px;float:left;height:32px;padding:0px;\" onchange=\"toGoPage(1,this.value)\">\n");
                sb.append("	<option value='10'>10</option>\n");
                sb.append("	<option value='20'>20</option>\n");
                sb.append("	<option value='30'>30</option>\n");
                sb.append("	<option value='40'>40</option>\n");
                sb.append("	<option value='50'>50</option>\n");
                sb.append("	<option value='60'>60</option>\n");
                sb.append("	<option value='70'>70</option>\n");
                sb.append("	<option value='80'>80</option>\n");
                sb.append("	<option value='90'>90</option>\n");
                sb.append("	<option value='100'>100</option>\n");
                sb.append("	</select>\n");
                sb.append("	</li>\n");
                sb.append(" <li class=\"\"><input id='jumpPage' class='ftt-input' style=\"width:55px;float:left;height:32px;padding:0px;border-radius:5px;\" type='number' value='" + page.getPageNum() + "' /></li>\n");
                sb.append(" <li class=\"\"><a href=\"javascript:void(0);\" style='background-color:#2890E0' onclick=\"toJumpPage(this," + page.getPageSize() + ")\">跳转</a></li>\n");
            }
            sb.append("</ul>\n");
        }
        String pageStr = sb.toString().replace("option value='" + page.getPageSize() + "'", "option value='" + page.getPageSize() + "' selected");
        return pageStr;
    }


    protected void startPage(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
    }

    protected Map<String, Object> setSuccess() {
        return setResult(true, null, null);
    }

    protected Map<String, Object> setSuccess(String msg) {
        return setResult(true, msg, null);
    }

    protected Map<String, Object> setSuccess(Object data) {
        return setResult(true, null, data);
    }

    protected Map<String, Object> setSuccess(String msg, Object data) {
        return setResult(true, msg, data);
    }

    protected Map<String, Object> setError(String msg) {
        return setResult(false, msg, null);
    }

    protected Map<String, Object> setError() {
        return setResult(false, null, null);
    }


}
