package com.ruoyi.village.domain;

import com.ruoyi.common.base.BaseEntity;
/**
 * 三级页面图片表 tb_andrpic
 *
 * @author hfz
 * @date 2019-11-04
 */
public class Andrpic extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 页面主题编号 */
    private Integer aid;
    /** 三级页面主题 */
    private String tname;
    /** 图片*/
    private String pic;
    /** 创建时间 */
    private String creadate;
    /** 信息状态  */
    private String remark;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCreadate() {
        return creadate;
    }

    public void setCreadate(String creadate) {
        this.creadate = creadate;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Andrpic{" +
                "aid=" + aid +
                ", tname='" + tname + '\'' +
                ", pic='" + pic + '\'' +
                ", creadate=" + creadate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
