package com.nxd.ftt.entity;
import com.google.gson.Gson;
import java.util.Date;

/**
 * User
 *
 * @author luhangqi
 * @date 2018/10/25
 */
public class User {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名（账号）
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 生日
     */
    private Date birthDay;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 星座
     */
    private String constellation;

    /**
     * 现居住地
     */
    private String address;

    /**
     * 故乡
     */
    private String hometown;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 性别 1:男 2:女
     */
    private Integer sex;

    /**
     * 公司
     */
    private String company;

    /**
     * 职业
     */
    private String job;

    /**
     * 学校
     */
    private String school;

    /**
     * 权限
     */
    private String rights;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 最后登录时间
     */
    private Date lastLogin;

    /**
     * 用户登录ip
     */
    private String ip;

    /**
     * 状态 0:禁用 1:正常 2:普通用户(无法登陆后台管理)
     */
    private String status;

    /**
     * 备注
     */
    private String bz;

    /**
     * 皮肤
     */
    private String skin;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    private String wechat;

    /**
     * QQ
     */
    private Integer qq;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 
     */
    private String number;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createor;

    /**
     * 修改人
     */
    private String updateor;

    /**
     * 个性签名
     */
    private String sign;


    /** 用户ID
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /** 用户名（账号）
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /** 密码
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /** 年龄
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /** 昵称
     *
     * @return nick
     */
    public String getNick() {
        return nick;
    }

    /** 生日
     *
     * @return birthDay
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /** 身份证号
     *
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /** 星座
     *
     * @return constellation
     */
    public String getConstellation() {
        return constellation;
    }

    /** 现居住地
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /** 故乡
     *
     * @return hometown
     */
    public String getHometown() {
        return hometown;
    }

    /** 真实姓名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /** 性别 1:男 2:女
     *
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /** 公司
     *
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /** 职业
     *
     * @return job
     */
    public String getJob() {
        return job;
    }

    /** 学校
     *
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /** 权限
     *
     * @return rights
     */
    public String getRights() {
        return rights;
    }

    /** 角色ID
     *
     * @return roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /** 最后登录时间
     *
     * @return lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /** 用户登录ip
     *
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /** 状态 0:禁用 1:正常 2:普通用户(无法登陆后台管理)
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /** 备注
     *
     * @return bz
     */
    public String getBz() {
        return bz;
    }

    /** 皮肤
     *
     * @return skin
     */
    public String getSkin() {
        return skin;
    }

    /** 邮箱
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /** 微信
     *
     * @return wechat
     */
    public String getWechat() {
        return wechat;
    }

    /** QQ
     *
     * @return qq
     */
    public Integer getQq() {
        return qq;
    }

    /** 手机号
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /** 
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /** 创建时间
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 修改时间
     *
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 创建人
     *
     * @return createor
     */
    public String getCreateor() {
        return createor;
    }

    /** 修改人
     *
     * @return updateor
     */
    public String getUpdateor() {
        return updateor;
    }

    /** 个性签名
     *
     * @return sign
     */
    public String getSign() {
        return sign;
    }


    /**
     * 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 用户名（账号）
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 昵称
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 生日
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 星座
     */
    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    /**
     * 现居住地
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 故乡
     */
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 性别 1:男 2:女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 公司
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 职业
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 学校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 权限
     */
    public void setRights(String rights) {
        this.rights = rights;
    }

    /**
     * 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 最后登录时间
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 用户登录ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 状态 0:禁用 1:正常 2:普通用户(无法登陆后台管理)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 备注
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * 皮肤
     */
    public void setSkin(String skin) {
        this.skin = skin;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 微信
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * QQ
     */
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    /**
     * 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人
     */
    public void setCreateor(String createor) {
        this.createor = createor;
    }

    /**
     * 修改人
     */
    public void setUpdateor(String updateor) {
        this.updateor = updateor;
    }

    /**
     * 个性签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}