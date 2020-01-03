package com.ruoyi.web.controller.village;

import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.VillagerInfo;
import com.ruoyi.village.service.IVillagerInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: ZX
 * @Description:
 * @Date: Create in 11:10 2019/11/10
 */
@Controller
@RequestMapping("village/statistics")
public class StatisticsController extends BaseController {

    private String prefix = "village/statistics";

    @Autowired
    private IVillagerInfoService villagerInfoService;

    @RequiresPermissions("village:statistics:view")
    @GetMapping()
    public String villagerInfo()
    {
        return prefix + "/statistics";
    }


}