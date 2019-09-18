package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.*;
import com.ruoyi.village.service.*;
import com.ruoyi.village.util.bFileUtil1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        worklog.setPageIndex((worklog.getPageIndex()-1)*worklog.getPageSize());
        return RongApiService.get_list(worklogService.selectWorklogListByid(worklog));
    }

    @PostMapping("/insertWorkLog")
    @CrossOrigin
    @ApiOperation(value = "新增工作记录")
    public AjaxResult insertWorkLog(Worklog worklog,@RequestParam(value = "files", required = false) MultipartFile file,
                                    @RequestParam(value = "filename", required = false) String fname,
                                    @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                                    @RequestParam(value = "fsize",required = false) String fsize )
    {
        String year = DateUtil.getYear();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(dateFormat.format(date));
        String maxfileid = dateFormat.format(date); //获取文件上传时的时间参数字符串作为文件名
        try{
            //保存图片
            Files g = bFileUtil1.uplodeFile(maxfileid, file, fname, flenth, fsize, year);
            worklog.setWpic(g.getAddress());//给project实体的“文件地址”赋值
        } catch (Exception e) {
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }
        return toAjax(worklogService.insertWorklog(worklog));
    }

    @GetMapping("/ListMemorial")
    @CrossOrigin
    @ApiOperation(value = "备忘录列表")
    public RongApiRes selectMemorial(pubObjApi memorial){
        memorial.setPageIndex((memorial.getPageIndex()-1)*memorial.getPageSize());
        return RongApiService.get_list(memorialService.selectMemorialListById(memorial));
    }

    @PostMapping("/insertMemorial")
    @CrossOrigin
    @ApiOperation(value = "新增备忘录")
    public AjaxResult insertMemorial(Memorial memorial,@RequestParam(value = "files", required = false) MultipartFile file,
                                     @RequestParam(value = "filename", required = false) String fname,
                                     @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                                     @RequestParam(value = "fsize",required = false) String fsize  )
    {
        String year = DateUtil.getYear();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(dateFormat.format(date));
        String maxfileid = dateFormat.format(date); //获取文件上传时的时间参数字符串作为文件名
        try{
            //保存图片
            Files g = bFileUtil1.uplodeFile(maxfileid, file, fname, flenth, fsize, year);
            memorial.setMpic(g.getAddress());//给project实体的“文件地址”赋值
        } catch (Exception e) {
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }
        return toAjax(memorialService.insertMemorial(memorial));
    }

    @GetMapping("/ListMeeting")
    @CrossOrigin
    @ApiOperation(value = "会议记录列表")
    public RongApiRes selectMeeting(pubObjApi meet){
        meet.setPageIndex((meet.getPageIndex()-1)*meet.getPageSize());
        return RongApiService.get_list(meetingService.selectMeetingListById(meet));
    }

    @PostMapping("/insertMeeting")
    @CrossOrigin
    @ApiOperation(value = "新增会议记录")
    public AjaxResult insertMeeting(Meeting meeting,@RequestParam(value = "files", required = false) MultipartFile file,
                                    @RequestParam(value = "filename", required = false) String fname,
                                    @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                                    @RequestParam(value = "fsize",required = false) String fsize )
    {
        String year = DateUtil.getYear();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(dateFormat.format(date));
        String maxfileid = dateFormat.format(date); //获取文件上传时的时间参数字符串作为文件名
        try{
            //保存图片
            Files g = bFileUtil1.uplodeFile(maxfileid, file, fname, flenth, fsize, year);
            meeting.setMpic(g.getAddress());//给project实体的“文件地址”赋值
        } catch (Exception e) {
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }
        return toAjax(meetingService.insertMeeting(meeting));
    }



    @PostMapping("/insertSuggest")
    @CrossOrigin
    @ApiOperation(value = "新增我的建议")
    public AjaxResult insertSuggest(Suggest suggest,@RequestParam(value = "files", required = false) MultipartFile file,
                                    @RequestParam(value = "filename", required = false) String fname,
                                    @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                                    @RequestParam(value = "fsize",required = false) String fsize )
    {
        String year = DateUtil.getYear();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(dateFormat.format(date));
        String maxfileid = dateFormat.format(date); //获取文件上传时的时间参数字符串作为文件名
        try{
            //保存图片
            Files g = bFileUtil1.uplodeFile(maxfileid, file, fname, flenth, fsize, year);
            suggest.setMpic(g.getAddress());//给project实体的“文件地址”赋值
        } catch (Exception e) {
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }
        return toAjax(suggestService.insertSuggest(suggest));
    }

    @GetMapping("/ListSuggest")
    @CrossOrigin
    @ApiOperation(value = "我的建议列表")
    public RongApiRes selectSuggest(pubObjApi meet){
        meet.setPageIndex((meet.getPageIndex()-1)*meet.getPageSize());
        return RongApiService.get_list(suggestService.selectSuggestListById(meet));
    }

    @GetMapping("/ListMyFile")
    @CrossOrigin
    @ApiOperation(value = "我的文件夹列表")
    public RongApiRes selectMyFile(pubObjApi myfile){
        myfile.setPageIndex((myfile.getPageIndex()-1)*myfile.getPageSize());
        return RongApiService.get_list(fileinfoService.selectMyFileListById(myfile));
    }

    @PostMapping("/img")
    @CrossOrigin
    @ApiOperation(value = "图片测试接口")
    public AjaxResult insertimg(@RequestParam(value = "files", required = false) MultipartFile file,
                                    @RequestParam(value = "filename", required = false) String fname,
                                    @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                                    @RequestParam(value = "fsize",required = false) String fsize )
    {
        String year = DateUtil.getYear();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(dateFormat.format(date));
        String maxfileid = dateFormat.format(date); //获取文件上传时的时间参数字符串作为文件名
        String imgurl="";
        try{
            //保存图片
            Files g = bFileUtil1.uplodeFile(maxfileid, file, fname, flenth, fsize, year);
            imgurl=g.getAddress();
        } catch (Exception e) {
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }
        return success(imgurl);
    }
}
