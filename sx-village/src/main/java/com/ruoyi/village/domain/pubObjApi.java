package com.ruoyi.village.domain;
import com.ruoyi.common.base.BaseEntity;


public class pubObjApi extends BaseEntity
{

    private Integer userid; //用户id
    private String title;
    private String state;
    private String beginTime;
    private String endTime;
    private Integer pageSize;
    private Integer pageIndex;
    private String aid; //地区编号
    private String uname; //姓名
    private String projectID;//项目id
    private String rural_Types;//美丽乡村类别

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getRural_Types() {
        return rural_Types;
    }

    public void setRural_Types(String rural_Types) {
        this.rural_Types = rural_Types;
    }
}