package com.ruoyi.village.domain;

import com.ruoyi.common.base.BaseEntity;

import java.util.List;

public class Comment extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**评论表id*/
    private int coid;
    /**评论所属新闻编号*/
    private String pcid;
    /**回复某评论的coid*/
    private String replyid;
    /**评论人id*/
    private int uid;
    /**评论人姓名*/
    private String uname;
    /**评论内容*/
    private String ccontent;
    /**是否为敏感评论 是为1 否为0*/
    private String issensitive;
    /**评论日期*/
    private String cdate;
    /**用户所属地区村社区 aid*/
    private String aid;
    /**评论目标用户id*/
    private String to_uid;
    /**评论目标人姓名*/
    private String to_name;
    //点赞
    private int good;

    private List<Comment> recomment;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public String getIssensitive() {
        return issensitive;
    }

    public void setIssensitive(String issensitive) {
        this.issensitive = issensitive;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(String to_uid) {
        this.to_uid = to_uid;
    }

    public String getTo_name() {
        return to_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public List<Comment> getRecomment() {
        return recomment;
    }

    public void setRecomment(List<Comment> recomment) {
        this.recomment = recomment;
    }
}
