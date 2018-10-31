package com.courier.db.entity;

import java.util.Date;
import javax.persistence.*;

public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 工号
     */
    @Column(name = "jobNo")
    private String jobno;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 开户行
     */
    @Column(name = "bankName")
    private String bankname;

    /**
     * 支行
     */
    @Column(name = "bankBranchName")
    private String bankbranchname;

    /**
     * 银行卡号
     */
    @Column(name = "bankCardNo")
    private String bankcardno;

    /**
     * 头像图片
     */
    @Column(name = "headPic")
    private String headpic;

    /**
     * 密码
     */
    private String password;

    /**
     * 网点代码
     */
    @Column(name = "orgCode")
    private String orgcode;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 修改时间
     */
    @Column(name = "updateTime")
    private Date updatetime;

    /**
     * 绑定渠道 1 ：支付宝 2 ：微信支付 3 ：百度支付 4 ：京东支付
     */
    @Column(name = "bindPay")
    private Integer bindpay;

    /**
     * 金刚手机号
     */
    @Column(name = "jGPhone")
    private String jgphone;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取工号
     *
     * @return jobNo - 工号
     */
    public String getJobno() {
        return jobno;
    }

    /**
     * 设置工号
     *
     * @param jobno 工号
     */
    public void setJobno(String jobno) {
        this.jobno = jobno;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取开户行
     *
     * @return bankName - 开户行
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * 设置开户行
     *
     * @param bankname 开户行
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    /**
     * 获取支行
     *
     * @return bankBranchName - 支行
     */
    public String getBankbranchname() {
        return bankbranchname;
    }

    /**
     * 设置支行
     *
     * @param bankbranchname 支行
     */
    public void setBankbranchname(String bankbranchname) {
        this.bankbranchname = bankbranchname;
    }

    /**
     * 获取银行卡号
     *
     * @return bankCardNo - 银行卡号
     */
    public String getBankcardno() {
        return bankcardno;
    }

    /**
     * 设置银行卡号
     *
     * @param bankcardno 银行卡号
     */
    public void setBankcardno(String bankcardno) {
        this.bankcardno = bankcardno;
    }

    /**
     * 获取头像图片
     *
     * @return headPic - 头像图片
     */
    public String getHeadpic() {
        return headpic;
    }

    /**
     * 设置头像图片
     *
     * @param headpic 头像图片
     */
    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取网点代码
     *
     * @return orgCode - 网点代码
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * 设置网点代码
     *
     * @param orgcode 网点代码
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取修改时间
     *
     * @return updateTime - 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置修改时间
     *
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取绑定渠道 1 ：支付宝 2 ：微信支付 3 ：百度支付 4 ：京东支付
     *
     * @return bindPay - 绑定渠道 1 ：支付宝 2 ：微信支付 3 ：百度支付 4 ：京东支付
     */
    public Integer getBindpay() {
        return bindpay;
    }

    /**
     * 设置绑定渠道 1 ：支付宝 2 ：微信支付 3 ：百度支付 4 ：京东支付
     *
     * @param bindpay 绑定渠道 1 ：支付宝 2 ：微信支付 3 ：百度支付 4 ：京东支付
     */
    public void setBindpay(Integer bindpay) {
        this.bindpay = bindpay;
    }

    /**
     * 获取金刚手机号
     *
     * @return jGPhone - 金刚手机号
     */
    public String getJgphone() {
        return jgphone;
    }

    /**
     * 设置金刚手机号
     *
     * @param jgphone 金刚手机号
     */
    public void setJgphone(String jgphone) {
        this.jgphone = jgphone;
    }
}