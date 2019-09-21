package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Comment;
import com.ruoyi.village.domain.pubObjApi;
import com.ruoyi.village.service.IPolicyinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
@Api(value = "村务模块 - 公告功能API类")
public class Vcomment extends BaseController {

    @Autowired
    private IPolicyinfoService policyinfoService;

    @GetMapping("/infoAll")
    @CrossOrigin
    @ApiOperation(value = "返回最近五条公告评论信息")
    public RongApiRes searchinfofive(pubObjApi info){
        info.setPageIndex((info.getPageIndex()-1)*info.getPageSize());
        List<Comment> commentlist =policyinfoService.selectinfocommentListlimit(info);
        // 遍历存储回复的评论
        for(Comment comment : commentlist){
            comment.setRecomment(policyinfoService.selectinforecommentList(comment.getCoid()));
        }
        return RongApiService.get_list(commentlist);
    }

    @PostMapping("/insertInfoCM")
    @CrossOrigin
    @ApiOperation(value = "新增公告评论")
    public AjaxResult insertInfoCM(Comment comment){

        System.out.println(comment.getPcid());
        return toAjax(policyinfoService.insertInfoCM(comment));
    }
}
