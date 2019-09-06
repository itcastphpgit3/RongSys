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

/**
 * 村务模块中党员值班功能的接口
 *
 * @author 张超
 */
@RestController
@RequestMapping("/api/pwork")
@CrossOrigin
@Api(value = "村务模块 - 党员值班API类")
public class Pwork extends BaseController {

    @Autowired
    private IPartyworkService partyworkService;
    @Autowired
    private IWorklogService worklogService;
    @Autowired
    private IMemorialService memorialService;
    @Autowired
    private IMeetingService meetingService;
    @Autowired
    private ISuggestService suggestService;
    @Autowired
    private IFileinfoService fileinfoService;
    /**
        * 返回最近五条党员值班信息
        * @author 张超 teavamc
        * @date 2019/1/25
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/five")
    @CrossOrigin
    @ApiOperation(value = "返回最近五条党员值班信息")
    public RongApiRes searchfive(){
        return RongApiService.get_list(partyworkService.selectPartyworkListlimit5());
    }

    @GetMapping("/ListWorkLog")
    @CrossOrigin
    @ApiOperation(value = "工作记录列表")
    public RongApiRes selectWorkLog(pubObjApi worklog){
        return RongApiService.get_list(worklogService.selectWorklogListByid(worklog));
    }

    @PostMapping("/insertWorkLog")
    @CrossOrigin
    @ApiOperation(value = "新增工作记录")
    public AjaxResult insertWorkLog(Worklog worklog )
    {
        return toAjax(worklogService.insertWorklog(worklog));
    }

    @GetMapping("/ListMemorial")
    @CrossOrigin
    @ApiOperation(value = "备忘录列表")
    public RongApiRes selectMemorial(pubObjApi memorial){
        return RongApiService.get_list(memorialService.selectMemorialListById(memorial));
    }

    @PostMapping("/insertMemorial")
    @CrossOrigin
    @ApiOperation(value = "新增备忘录")
    public AjaxResult insertMemorial(Memorial memorial)
    {
        return toAjax(memorialService.insertMemorial(memorial));
    }

    @GetMapping("/ListMeeting")
    @CrossOrigin
    @ApiOperation(value = "会议记录列表")
    public RongApiRes selectMeeting(pubObjApi meet){
        return RongApiService.get_list(meetingService.selectMeetingListById(meet));
    }

    @PostMapping("/insertMeeting")
    @CrossOrigin
    @ApiOperation(value = "新增会议记录")
    public AjaxResult insertMeeting(Meeting meeting)
    {
        return toAjax(meetingService.insertMeeting(meeting));
    }



    @PostMapping("/insertSuggest")
    @CrossOrigin
    @ApiOperation(value = "新增我的建议")
    public AjaxResult insertSuggest(Suggest suggest)
    {
        return toAjax(suggestService.insertSuggest(suggest));
    }

    @GetMapping("/ListSuggest")
    @CrossOrigin
    @ApiOperation(value = "我的建议列表")
    public RongApiRes selectSuggest(pubObjApi meet){
        return RongApiService.get_list(suggestService.selectSuggestListById(meet));
    }

    @GetMapping("/ListMyFile")
    @CrossOrigin
    @ApiOperation(value = "我的文件夹列表")
    public RongApiRes selectMyFile(pubObjApi myfile){
        return RongApiService.get_list(fileinfoService.selectMyFileListById(myfile));
    }


}
