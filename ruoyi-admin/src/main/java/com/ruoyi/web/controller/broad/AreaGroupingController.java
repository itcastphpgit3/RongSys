package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.AreaGrouping;
import com.ruoyi.broad.service.IAreaGroupingService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ASUS on 2019/8/2.
 * @author cx
 * 终端分组管理控制
 */
@Controller
@RequestMapping("/broad/areagrouping")
public class AreaGroupingController extends BaseController{

    private String prefix = "broad/areagrouping";

    @Autowired
    private IAreaGroupingService iAreaGroupingService;

    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping()
    public String areaGrouping()
    {
        return prefix + "/areaGrouping";
    }

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
            List<AreaGrouping> list = iAreaGroupingService.list();
            return getDataTable(list);
        }else {
            startPage();
            areaGrouping.setUid(userid);
            List<AreaGrouping> list = iAreaGroupingService.list();
            return getDataTable(list);
        }
    }
}
