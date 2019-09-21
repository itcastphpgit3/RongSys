package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.UserInfoDTO;
import com.ruoyi.broad.mapper.UserInfoDTOMapper;
import com.ruoyi.broad.service.IUserInfoDTOService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoDTOServiceImpl implements IUserInfoDTOService {

    @Autowired
    private UserInfoDTOMapper userInfoDTOMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<UserInfoDTO> findAll(){
        return userInfoDTOMapper.findAll();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public UserInfoDTO findById(String userid){
        return userInfoDTOMapper.findById(userid);
    }

}
