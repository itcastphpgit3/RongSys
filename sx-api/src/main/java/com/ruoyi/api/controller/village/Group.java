package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;

import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.village.domain.Partymember;
import com.ruoyi.village.domain.pubObjApi;
import com.ruoyi.village.service.IPartymemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/group")
@CrossOrigin
@Api(value = "党建模块 - 党员小组API类")
public class Group {
    @Autowired
    private IPartymemberService partymemberService;
    @Autowired
    private IOrganizationService organizationService;

    @GetMapping("/all")
    @CrossOrigin
    @ApiOperation(value = "党员信息")
    public RongApiRes searchAll(pubObjApi group)
    {
        group.setPageIndex((group.getPageIndex()-1)*group.getPageSize());
        return RongApiService.get_list(partymemberService.selectPartymemberListBytype(group));
    }

    @GetMapping("/grouplist")
    @CrossOrigin
    @ApiOperation(value = "党员小组")
    public RongApiRes selectGrouplist(pubObjApi group)
    {
        group.setPageIndex((group.getPageIndex()-1)*group.getPageSize());
        List<Partymember> res;
        List<String> allaid = organizationService.listNextAid(group.getAid());
        if (allaid.isEmpty()){
            allaid.add(group.getAid());
            group.setListaid(allaid);
            res = partymemberService.selectGrouplist(group);
        }else {
            //获得所有的子 aid 放入 list
            List<String> temp;
            temp = organizationService.listNextAid(allaid.get(0));
            for (int i = 1; i < allaid.size(); i++){
                List<String> l = organizationService.listNextAid(allaid.get(i));
                if (!l.isEmpty()){
                    temp.addAll(l);
                }
            }
            allaid.addAll(temp);
            // 遍历所有的 aid 信息然后装入结果
            group.setListaid(allaid);
            res = partymemberService.selectGrouplist(group);
        }
        return RongApiService.get_list(res);
    }


}
