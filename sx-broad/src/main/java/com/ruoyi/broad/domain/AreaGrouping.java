package com.ruoyi.broad.domain;

import java.util.List;

/**
 * Created by ASUS on 2019/8/2.
 * @author 陈霞
 * 分组管理
 */
public class AreaGrouping {
    private String aid;//区域编号
    private String parentaid;//父区域编号
    private String aname;//区域名称
    private String note;//备注
    private String userid;//备注

    private String parentaname;
    private List<Area> subArea;
    private Long uid;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getParentaid() {
        return parentaid;
    }

    public void setParentaid(String parentaid) {
        this.parentaid = parentaid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentaname() {
        return parentaname;
    }

    public void setParentaname(String parentaname) {
        this.parentaname = parentaname;
    }

    public List<Area> getSubArea() {
        return subArea;
    }

    public void setSubArea(List<Area> subArea) {
        this.subArea = subArea;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "AreaGrouping{" +
                "aid='" + aid + '\'' +
                ", parentaid='" + parentaid + '\'' +
                ", aname='" + aname + '\'' +
                ", note='" + note + '\'' +
                ", userid='" + userid + '\'' +
                ", parentaname='" + parentaname + '\'' +
                ", subArea=" + subArea +
                ", uid=" + uid +
                '}';
    }
}
