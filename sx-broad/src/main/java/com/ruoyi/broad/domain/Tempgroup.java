package com.ruoyi.broad.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * Created by ASUS on 2019/7/29.
 * @author cx
 */
public class Tempgroup extends BaseEntity {

    /*临时分组编号*/
    private int tgid;

    /*临时分组名称*/
    private String tgname;

    /*终端名称*/
    private String tname;

    /*建立人*/
    private String userid;

    /*使用权限人*/
    private String rightuname;

    /*创建时间*/
    private String createdtime;

    /*这个字段数据库里没注释，暂时不知道其作用*/
    private String note;

    /*这个字段在数据库里是bit查询的时候要注意一下，表示是否启用*/
    private String isuse;

    /*设备IEME*/
    private String tid;

    /*所属分组id*/
    private String aid;

    /*区域名称*/
    private String aname;

    /*用户名*/
    private String uname;

    /*用户电话*/
    private String phone;

    /*终端地址*/
    private String address;

    private String parentaid;

    private int listId;

    public int getTgid() {
        return tgid;
    }

    public void setTgid(int tgid) {
        this.tgid = tgid;
    }

    public String getTgname() {
        return tgname;
    }

    public void setTgname(String tgname) {
        this.tgname = tgname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRightuname() {
        return rightuname;
    }

    public void setRightuname(String rightuname) {
        this.rightuname = rightuname;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIsuse() {
        return isuse;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentaid() {
        return parentaid;
    }

    public void setParentaid(String parentaid) {
        this.parentaid = parentaid;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tempgroup").append('[')
                .append("tgid=")
                .append(tgid)
                .append(",tgname=")
                .append(tgname)
                .append(",tname=")
                .append(tname)
                .append(",userid=")
                .append(userid)
                .append(",rightuname=")
                .append(rightuname)
                .append(",createdtime=")
                .append(createdtime)
                .append(",note=")
                .append(note)
                .append(",isuse=")
                .append(isuse)
                .append(",tid=")
                .append(tid)
                .append(",aid=")
                .append(aid)
                .append(",aname=")
                .append(aname)
                .append(",uname=")
                .append(uname)
                .append(",phone=")
                .append(phone)
                .append(",address=")
                .append(address)
                .append(",parentaid=")
                .append(parentaid)
                .append(",listId=")
                .append(listId)
                .append(']');
        return sb.toString();
    }
}
