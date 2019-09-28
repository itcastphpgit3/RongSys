package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 终端表 tb_organization
 *
 * @author cx
 * @date 2019-09-21
 */
public class Organization extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**终端imei*/
    private String tid;
    /**设备编号*/
    private String tname;
    /**所属用户*/
    private String username;
    /**所属分组*/
    private String aname;
    /**最后访问日期*/
    private String lastaccesstime;
    /**交互时间*/
    private String intertime;
    /**终端类型*/
    private String terminaltype;
    /**终端经度*/
    private String Longitude;
    /**终端纬度*/
    private String Latitude;
    /**基站编码*/
    private String basestation;
    /**终端手机号码*/
    private String phone;
    /**年度维护经费*/
    private String MaintenanceFunds;
    /**年耗电量*/
    private String ypowerconsumption;
    /**流量使用情况*/
    private String usetraffic;
    /**在线状态*/
    private String onlinestate;
    /**DCS码*/
    private String dcs;
    /**发射功率*/
    private String transmitpower;
    /**发射频率*/
    private String transmitfrequency;
    /**反射功率*/
    private String reflectedpower;
    /**反射电压*/
    private String workvoltage;
    /**电池电压*/
    private String batteryvoltage;
    /**负载电流*/
    private String loadcurrent;
    /**供电模式*/
    private String pdmode;
    /**充电电流*/
    private String chargecurrent;
    /**对讲接收频率*/
    private String fmfrequency;
    /**终端管理员*/
    private String manager;
    /**管理员电话*/
    private String managertel;
    /**创建时间*/
    private String createdtime;
    /**是否启用*/
    private boolean isuse;

    private String isused;
    /**终端地址*/
    private String address;
    /**终端地域id*/
    private String aid;
    /**备注*/
    private String note;
    /**rds码*/
    private String rds;
    /**终端授权号码*/
    private String atphone;
    /**广播接收频率*/
    private String brfrequency;
    /**出厂编号*/
    private String facid;
    /**网络类型*/
    private String nettype;
    /**月流量使用*/
    private String mflowusing;
    /**对讲接收频率*/
    private String irfrequency;
    /**终端音量*/
    private String eovolume;
    /**现场照片*/
    private String poscene;
    /**父地域id*/
    private String parentaid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getLastaccesstime() {
        return lastaccesstime;
    }

    public void setLastaccesstime(String lastaccesstime) {
        this.lastaccesstime = lastaccesstime;
    }

    public String getIntertime() {
        return intertime;
    }

    public void setIntertime(String intertime) {
        this.intertime = intertime;
    }

    public String getTerminaltype() {
        return terminaltype;
    }

    public void setTerminaltype(String terminaltype) {
        this.terminaltype = terminaltype;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getBasestation() {
        return basestation;
    }

    public void setBasestation(String basestation) {
        this.basestation = basestation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMaintenanceFunds() {
        return MaintenanceFunds;
    }

    public void setMaintenanceFunds(String maintenanceFunds) {
        MaintenanceFunds = maintenanceFunds;
    }

    public String getYpowerconsumption() {
        return ypowerconsumption;
    }

    public void setYpowerconsumption(String ypowerconsumption) {
        this.ypowerconsumption = ypowerconsumption;
    }

    public String getUsetraffic() {
        return usetraffic;
    }

    public void setUsetraffic(String usetraffic) {
        this.usetraffic = usetraffic;
    }

    public String getOnlinestate() {
        return onlinestate;
    }

    public void setOnlinestate(String onlinestate) {
        this.onlinestate = onlinestate;
    }

    public String getDcs() {
        return dcs;
    }

    public void setDcs(String dcs) {
        this.dcs = dcs;
    }

    public String getTransmitpower() {
        return transmitpower;
    }

    public void setTransmitpower(String transmitpower) {
        this.transmitpower = transmitpower;
    }

    public String getTransmitfrequency() {
        return transmitfrequency;
    }

    public void setTransmitfrequency(String transmitfrequency) {
        this.transmitfrequency = transmitfrequency;
    }

    public String getReflectedpower() {
        return reflectedpower;
    }

    public void setReflectedpower(String reflectedpower) {
        this.reflectedpower = reflectedpower;
    }

    public String getWorkvoltage() {
        return workvoltage;
    }

    public void setWorkvoltage(String workvoltage) {
        this.workvoltage = workvoltage;
    }

    public String getBatteryvoltage() {
        return batteryvoltage;
    }

    public void setBatteryvoltage(String batteryvoltage) {
        this.batteryvoltage = batteryvoltage;
    }

    public String getLoadcurrent() {
        return loadcurrent;
    }

    public void setLoadcurrent(String loadcurrent) {
        this.loadcurrent = loadcurrent;
    }

    public String getPdmode() {
        return pdmode;
    }

    public void setPdmode(String pdmode) {
        this.pdmode = pdmode;
    }

    public String getChargecurrent() {
        return chargecurrent;
    }

    public void setChargecurrent(String chargecurrent) {
        this.chargecurrent = chargecurrent;
    }

    public String getFmfrequency() {
        return fmfrequency;
    }

    public void setFmfrequency(String fmfrequency) {
        this.fmfrequency = fmfrequency;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagertel() {
        return managertel;
    }

    public void setManagertel(String managertel) {
        this.managertel = managertel;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public boolean isIsuse() {
        return isuse;
    }

    public void setIsuse(boolean isuse) {
        this.isuse = isuse;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRds() {
        return rds;
    }

    public void setRds(String rds) {
        this.rds = rds;
    }

    public String getAtphone() {
        return atphone;
    }

    public void setAtphone(String atphone) {
        this.atphone = atphone;
    }

    public String getBrfrequency() {
        return brfrequency;
    }

    public void setBrfrequency(String brfrequency) {
        this.brfrequency = brfrequency;
    }

    public String getFacid() {
        return facid;
    }

    public void setFacid(String facid) {
        this.facid = facid;
    }

    public String getNettype() {
        return nettype;
    }

    public void setNettype(String nettype) {
        this.nettype = nettype;
    }

    public String getMflowusing() {
        return mflowusing;
    }

    public void setMflowusing(String mflowusing) {
        this.mflowusing = mflowusing;
    }

    public String getIrfrequency() {
        return irfrequency;
    }

    public void setIrfrequency(String irfrequency) {
        this.irfrequency = irfrequency;
    }

    public String getEovolume() {
        return eovolume;
    }

    public void setEovolume(String eovolume) {
        this.eovolume = eovolume;
    }

    public String getPoscene() {
        return poscene;
    }

    public void setPoscene(String poscene) {
        this.poscene = poscene;
    }

    public String getParentaid() {
        return parentaid;
    }

    public void setParentaid(String parentaid) {
        this.parentaid = parentaid;
    }
}
