package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.UserInfoDTO;

import java.util.List;

public interface UserInfoDTOMapper {

    List<UserInfoDTO> findAll();

    UserInfoDTO findById(String userid);
}
