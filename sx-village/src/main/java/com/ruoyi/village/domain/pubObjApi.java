package com.ruoyi.village.domain;
import com.ruoyi.common.base.BaseEntity;


public class pubObjApi extends BaseEntity
{

    private Integer userid; //用户id
    private String ProjectID;//项目id
    private String Rural_Types;//美丽乡村类别
    private String Title;

    private String state;

    private String beginTime;
    private String EndTime;
    private Integer PageSize;
    private Integer PageIndex;
    private String aid; //地区编号
    private String uname; //姓名

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(Integer pageIndex) {

        PageIndex = (pageIndex-1)*20;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public String getRural_Types() {
        return Rural_Types;
    }

    public void setRural_Types(String rural_Types) {
        Rural_Types = rural_Types;
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
}