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
@RequestMapping("/village/analysis")
public class AnalysisController extends BaseController {

    private String prefix = "village/analysis";

    @Autowired
    private IVillagerInfoService villagerInfoService;

    @RequiresPermissions("village:analysis:view")
    @GetMapping()
    public String villagerInfo()
    {
        return prefix + "/analysis";
    }

    /**
     * 查询村民并分析性别比例
     */
    @RequiresPermissions("village:analysis:list")
    @PostMapping("/count")
    @ResponseBody
    public String Groupsexy(String grouptype)
    {

        List<VillagerInfo> list = villagerInfoService.selectVillagerInfoListBygrouptype(grouptype);
        Integer count=list.size();//总数
        Integer fnum=0;//男数量
        Integer fmnum=0;//女数量
        for(int i=0;i<count;i++){
            if("男".equals(list.get(i).getSex())) {
                fnum++;
            }else{
                fmnum++;
          }

        }
        String result=count.toString()+'|'+fnum.toString()+'|'+ fmnum.toString();

        return result;
    }
}
