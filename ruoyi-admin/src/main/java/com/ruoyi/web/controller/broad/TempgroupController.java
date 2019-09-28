package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.BroadMessage;
import com.ruoyi.broad.domain.Tempgroup;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.broad.service.IMessageService;
import com.ruoyi.broad.service.ITempgroupService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2019/7/30.
 * @author cx
 * @description 特殊分组管理
 */
@Controller
@RequestMapping("/broad/tempgroup")
public class TempgroupController<addtemp> extends BaseController{

    private String prefix = "broad/tempgroup";

    @Autowired
    private ITempgroupService iTempgroupService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private IAreaService areaService;

    @Autowired
    private IMessageService messageService;

    @GetMapping()
    public String getTempgroup()
    {
        return prefix + "/tempgroup";
    }

    @PostMapping("/list/{tgname}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("tgname") String tgname){
        startPage();
        System.out.println("helli");
        List<Tempgroup> list = iTempgroupService.selectAllTempgroup(tgname);
        return getDataTable(list);
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(){
        startPage();
        List<Tempgroup> list = iTempgroupService.selectTempgroup();
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String addMaintainApply()
    {
        return prefix + "/add";
    }

    @Log(title = "新增临时分组", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Tempgroup tempgroup)
    {
        return toAjax(iTempgroupService.insertTempgroup(tempgroup));
    }

    @PostMapping("/remove")
    @Log(title = "临时分组删除",businessType = BusinessType.DELETE)
    @ResponseBody
    public AjaxResult remove(String tgid){
        return toAjax(iTempgroupService.deleteTempgroup(tgid));
//        return iTempgroupService.deleteTempgroup(tgid);
    }

    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String,Object>> treedata()
    {
        SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
        Long userid =  currentUser.getUserId();
        int returnId = new Long(userid).intValue();
        int roleid = iSysUserService.selectRoleid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
        List<Map<String, Object>> tree = messageService.selectMessageList((new BroadMessage()));
        return tree;

    }

    @GetMapping("/detail/{aid}")
    @Log(title = "申请维护记录详细")
    public String detail(@PathVariable("aid") String aid, ModelMap mmp)
    {
        mmp.put("name","tempgroup");
        mmp.put("tempgroup",iTempgroupService.selectTempgroupById(aid));
        return prefix + "/detail";
    }

    @GetMapping("/add1")
    public String addMaintainApply(ModelMap modelMap){
        return prefix + "/add1";
    }

    @GetMapping("/add2")
    public String addMaintainApply1(ModelMap modelMap){
        return prefix + "/add2";
    }

//    @Log(title = "申请维护记录增加", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(Tempgroup tempgroup){
//        System.out.println(tempgroup);
//        return toAjax(iTempgroupService.insertTempgroup(tempgroup));
//    }

    @PostMapping("/addtemp")
    @ResponseBody
    public String addTemp(Tempgroup tempgroup){
        int i = iTempgroupService.insertTempgroup(tempgroup);
        return "success";
    }

    @PostMapping("/tempgroup_ter")
    @ResponseBody
    public String tempgroup_ter(Tempgroup tempgroup){

        int i = iTempgroupService.insertTempgroupT(tempgroup);
        return "success";
    }

    @PostMapping("/removet")
    @ResponseBody
    public AjaxResult removeT(String tid){
        return toAjax(iTempgroupService.deleteTempgroupT(tid));
    }
}
