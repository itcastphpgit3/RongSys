package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.village.domain.Partymember;
import com.ruoyi.village.domain.PersonApi;
import com.ruoyi.village.domain.VillagerInfo;
import com.ruoyi.village.service.IPersonalDetailService;
import com.ruoyi.village.service.IProjectService;
import com.ruoyi.village.service.IVillagerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
@Api(value = "个人信息API类")
public class Person {
    @Autowired
    private IPersonalDetailService personalDetailService;
    @Autowired
    private IVillagerInfoService villagerInfoService;
    @Autowired
    private IOrganizationService organizationService;

    @GetMapping("/all")
    @CrossOrigin
    @ApiOperation(value = "查询个人详细信息")
    public RongApiRes searchPerson(Integer pdid)
    {
        return RongApiService.get_bean(personalDetailService.selectPersonalDetailById(pdid));
    }

    @GetMapping("/perAllInfo")
    @CrossOrigin
    @ApiOperation(value = "查询个人详细信息")
    public RongApiRes selectPersonAll(PersonApi person)
    {
        person.setPageIndex((person.getPageIndex()-1)*person.getPageSize());
        List<VillagerInfo> res;
        List<String> allaid = organizationService.listNextAid(person.getAid());
        if (allaid.isEmpty()){
            allaid.add(person.getAid());
            person.setListaid(allaid);
            res = villagerInfoService.selectPersonAllByApi(person);
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
            person.setListaid(allaid);
            res = villagerInfoService.selectPersonAllByApi(person);
        }
        return RongApiService.get_list(res);
    }

    @GetMapping("/cadreinfo")
    @CrossOrigin
    @ApiOperation(value = "村工作人员列表")
    public RongApiRes selectbycadre(PersonApi person){
        person.setPageIndex((person.getPageIndex()-1)*person.getPageSize());
        List<VillagerInfo> res;
        List<String> allaid = organizationService.listNextAid(person.getAid());
        if (allaid.isEmpty()){
            allaid.add(person.getAid());
            person.setListaid(allaid);
            res = villagerInfoService.selectbycadre(person);
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
            person.setListaid(allaid);
            res = villagerInfoService.selectbycadre(person);
        }
        return RongApiService.get_list(res);
    }

}
