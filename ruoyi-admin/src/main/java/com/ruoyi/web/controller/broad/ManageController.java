package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Maintain;
import com.ruoyi.broad.domain.Manage;
import com.ruoyi.broad.service.IManageService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cx
 * @Time 2019/8/20 16:24
 * @Description
 */
@Controller
@RequestMapping("/broad/manage")
public class ManageController extends BaseController{

    private String prefix = "broad/manage";

    @Autowired
    private IManageService iManageService;

    @GetMapping()
    public String manage()
    {
        return prefix + "/manage";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Manage manage)
    {
        startPage();
        List<Manage> list = iManageService.selectManagelist(manage);
        return getDataTable(list);
    }
}
