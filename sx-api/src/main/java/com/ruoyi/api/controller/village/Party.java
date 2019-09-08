package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.*;
import com.ruoyi.village.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/party")
@CrossOrigin
@Api(value = "党建模块 - 党员活动API类")
public class Party extends BaseController {
    @Autowired
    private IHuodongService huodongService;
    @Autowired
    private IPartystudyService partystudyService;
    @Autowired
    private IPartyaffairsService partyaffairsService;
    @Autowired
    private IShishiService shishiService;
    @Autowired
    private IPartynewService partynewService;
    @Autowired
    private IPartyfupinService partyfupinService;
    /**
     * 返回所有党员活动信息
     * @author 施景程 teavamc
     * @date 2019/6/8
     * @param []
     * @return com.ruoyi.api.domain.RongApiRes
     */
    @GetMapping("/hdAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党员活动信息")
    public RongApiRes searchAll(Huodong huodong)
    {
        return RongApiService.get_list(huodongService.selectHuodongList(huodong));
    }
    @PostMapping("/insertHd")
    @CrossOrigin
    @ApiOperation(value = "新增党员活动信息")
    public AjaxResult insertHd(Huodong huodong)
    {
        return toAjax(huodongService.inserthuodong(huodong));
    }

    @GetMapping("/eduAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党员学习信息")
    public RongApiRes searchEduAll(Partystudy partystudy)
    {
        return RongApiService.get_list(partystudyService.selectPartystudyList(partystudy));
    }

    @GetMapping("/affairAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党务公开信息")
    public RongApiRes searchAffairAll(Partyaffairs partyaffairs)
    {
        return RongApiService.get_list(partyaffairsService.selectPartyaffairsList(partyaffairs));
    }

    @GetMapping("/shishiAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党务公开信息")
    public RongApiRes selectShishiList(Shishi shishi)
    {
        return RongApiService.get_list(shishiService.selectShishiList(shishi));
    }

    @GetMapping("/listAll")
    @CrossOrigin
    @ApiOperation(value = "党建各栏目列表")
    public RongApiRes selectPartyAllById(pubObjApi party)
    {
        party.setPageIndex((party.getPageIndex()-1)*party.getPageSize());
        switch(party.getVtype()){
            case "0":
                return RongApiService.get_list(partynewService.selectpartynewListById(party));
            case "1":
                return RongApiService.get_list(huodongService.selectHuodongListById(party));
            case "2":
                return RongApiService.get_list(partystudyService.selectPartystudyListById(party));
            case "3":
                return RongApiService.get_list(partyfupinService.selectfupinListById(party));
            default:
                return null;
        }
    }

    @PostMapping("/insertPNew")
    @CrossOrigin
    @ApiOperation(value = "新增党员新闻")
    public AjaxResult insertPartyNew(Partynew partynew)
    {
        return toAjax(partynewService.insertPartynew(partynew));
    }

    @PostMapping("/insertEducation")
    @CrossOrigin
    @ApiOperation(value = "新增党员学习")
    public AjaxResult insertEducation(Partystudy partystudy)
    {
        return toAjax(partystudyService.insertPartystudy(partystudy));
    }

    @PostMapping("/insertFuPin")
    @CrossOrigin
    @ApiOperation(value = "新增扶贫工作")
    public AjaxResult insertPartyfupin(Partyfupin partyfupin)
    {
        return toAjax(partyfupinService.insertPartyfupin(partyfupin));
    }
}
