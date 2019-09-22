package com.ruoyi.broad.domain;


public class UserInfoDTO {

    private String userid;
    private String uname;

    public String getUserid() {
        return userid;
    }

    public String getUname() {
        return uname;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userid='" + userid + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
