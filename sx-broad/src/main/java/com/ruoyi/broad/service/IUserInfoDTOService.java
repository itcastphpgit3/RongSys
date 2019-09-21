package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.UserInfoDTO;

import java.util.List;

public interface IUserInfoDTOService {

    List<UserInfoDTO> findAll();

    UserInfoDTO findById(String userid);
}
