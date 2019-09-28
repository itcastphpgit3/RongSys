package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.AreaGrouping;
import com.ruoyi.broad.domain.BroadMessage;
import com.ruoyi.broad.domain.MaintainApply;
import com.ruoyi.broad.service.IAreaGroupingService;
import com.ruoyi.broad.service.IMessageService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2019/8/2.
 * @author cx
 * 分组管理 控制层
 */
@Controller
@RequestMapping("/broad/areaGrouping")
public class AreaGroupingController extends BaseController{

    private String prefix = "broad/areaGrouping";

    @Autowired
    private IAreaGroupingService iAreaGroupingService;

    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping()
    public String areaGrouping()
    {
        return prefix + "/areaGrouping";
    }

    @Autowired
    private IMessageService messageService;

    @PostMapping("/list")
    @Log(title = "分组管理列表")
    @ResponseBody
    public TableDataInfo list(AreaGrouping areaGrouping)
    {
        SysUser currentUser = ShiroUtils.getSysUser();  //从session中获取当前登陆用户的userid
        Long userid = currentUser.getUserId();
        int returnid = new Long(userid).intValue();
        int roleid = iSysUserService.selectRoleid(returnid); //通过所获取的userid去广播用户表中查询用户所属区域的Roleid
        if(roleid == 1)
        {
            startPage();
            List<AreaGrouping> list = iAreaGroupingService.listAreaGrouping(areaGrouping);
            return getDataTable(list);
        }else {
            startPage();
            areaGrouping.setUid(userid);
            List<AreaGrouping> list = iAreaGroupingService.listAreaGrouping(areaGrouping);
            return getDataTable(list);
        }
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData() {
        List<Map<String, Object>> tree = messageService.selectMessageList((new BroadMessage()));
        return tree;
    }

    /**
     * @author cx
     * @Description 此删除方式可以批量删除，可以单独删除
     * @param ids
     * 注意 这个地方的参数一定要写ids 和前端绑定的固定格式
     */
    @PostMapping("/remove")
    @Log(title = "分组管理删除",businessType = BusinessType.DELETE)
    @RequiresPermissions("broad:areagrouping:remove")
    @ResponseBody
    public AjaxResult removeAreagrouping(String ids)
    {
        return toAjax(iAreaGroupingService.deleteAreaGroupingByIds(ids));
    }

    @GetMapping("/add")
    public String addareaGrouping()
    {
        return prefix + "/add";
    }

    @Log(title = "新增分组管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AreaGrouping areaGrouping)
    {
        return toAjax(iAreaGroupingService.insertAreaGrouping(areaGrouping));
    }
}