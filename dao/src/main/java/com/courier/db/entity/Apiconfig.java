package com.courier.db.entity;

import java.util.Date;
import javax.persistence.*;

public class Apiconfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 渠道名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 渠道（0:移动官网使用,1:微信使用,2:安卓App使用,3:C5使用,4:支付宝使用,5:会员平台使用,6:官网使用,7:IOSApp使用,8:百度轻应用使用）
     */
    private Byte source;

    /**
     * 公开给三方系统的key
     */
    private String token;

    /**
     * 权限（0:抢单通知（取件）,1:系统分配（取件）,2:取消取件订单,3:发送push,4:获取用户gps）5 离职员工 6获取手機號碼 7 通緝件
     */
    private Byte permission;

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
     * 获取渠道名称
     *
     * @return name - 渠道名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置渠道名称
     *
     * @param name 渠道名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取渠道（0:移动官网使用,1:微信使用,2:安卓App使用,3:C5使用,4:支付宝使用,5:会员平台使用,6:官网使用,7:IOSApp使用,8:百度轻应用使用）
     *
     * @return source - 渠道（0:移动官网使用,1:微信使用,2:安卓App使用,3:C5使用,4:支付宝使用,5:会员平台使用,6:官网使用,7:IOSApp使用,8:百度轻应用使用）
     */
    public Byte getSource() {
        return source;
    }

    /**
     * 设置渠道（0:移动官网使用,1:微信使用,2:安卓App使用,3:C5使用,4:支付宝使用,5:会员平台使用,6:官网使用,7:IOSApp使用,8:百度轻应用使用）
     *
     * @param source 渠道（0:移动官网使用,1:微信使用,2:安卓App使用,3:C5使用,4:支付宝使用,5:会员平台使用,6:官网使用,7:IOSApp使用,8:百度轻应用使用）
     */
    public void setSource(Byte source) {
        this.source = source;
    }

    /**
     * 获取公开给三方系统的key
     *
     * @return token - 公开给三方系统的key
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置公开给三方系统的key
     *
     * @param token 公开给三方系统的key
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取权限（0:抢单通知（取件）,1:系统分配（取件）,2:取消取件订单,3:发送push,4:获取用户gps）5 离职员工 6获取手機號碼 7 通緝件
     *
     * @return permission - 权限（0:抢单通知（取件）,1:系统分配（取件）,2:取消取件订单,3:发送push,4:获取用户gps）5 离职员工 6获取手機號碼 7 通緝件
     */
    public Byte getPermission() {
        return permission;
    }

    /**
     * 设置权限（0:抢单通知（取件）,1:系统分配（取件）,2:取消取件订单,3:发送push,4:获取用户gps）5 离职员工 6获取手機號碼 7 通緝件
     *
     * @param permission 权限（0:抢单通知（取件）,1:系统分配（取件）,2:取消取件订单,3:发送push,4:获取用户gps）5 离职员工 6获取手機號碼 7 通緝件
     */
    public void setPermission(Byte permission) {
        this.permission = permission;
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
}