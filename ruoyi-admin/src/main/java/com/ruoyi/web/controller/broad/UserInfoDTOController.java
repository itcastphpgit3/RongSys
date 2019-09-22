package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.UserInfoDTO;
import com.ruoyi.broad.service.IUserInfoDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/broad/dto")
public class UserInfoDTOController {

    @Autowired
    private IUserInfoDTOService userInfoDTOService;

    @GetMapping("/userinfos")
    public List<UserInfoDTO> findAll(){
        return userInfoDTOService.findAll();
    }

    @GetMapping("/userinfo/{userid}")
    public UserInfoDTO findById(@PathVariable("userid") String userid){
        return userInfoDTOService.findById(userid);
    }
}
